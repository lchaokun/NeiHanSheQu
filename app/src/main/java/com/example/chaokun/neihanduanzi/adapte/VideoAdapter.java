package com.example.chaokun.neihanduanzi.adapte;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.chaokun.neihanduanzi.R;
import com.example.chaokun.neihanduanzi.base.MyApplication;
import com.example.chaokun.neihanduanzi.bean.DataBase;
import com.example.chaokun.neihanduanzi.bean.Joke;
import com.example.chaokun.neihanduanzi.bean.Video;
import com.example.chaokun.neihanduanzi.callback.LoadFinishCallBack;
import com.example.chaokun.neihanduanzi.callback.LoadResultCallBack;
import com.example.chaokun.neihanduanzi.constant.Constants;
import com.example.chaokun.neihanduanzi.utils.DataBaseCrete;
import com.example.chaokun.neihanduanzi.utils.GsonUtil;
import com.example.chaokun.neihanduanzi.utils.ImageLoadProxy;
import com.example.chaokun.neihanduanzi.utils.MyHttpUtils;
import com.example.chaokun.neihanduanzi.utils.NetWorkUtil;
import com.example.chaokun.neihanduanzi.utils.ShareUtil;
import com.example.chaokun.neihanduanzi.utils.String2TimeUtil;
import com.example.chaokun.neihanduanzi.utils.TextUtil;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by linchaokun on 2016/6/9.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private int page;
    private int lastPosition = -1;
    private List<Video.DataBean> list;
    private Activity mActivity;
    private LoadResultCallBack mLoadResultCallBack;
    private LoadFinishCallBack mLoadFinisCallBack;
    private DataBaseCrete dataBaseCrete;

    public VideoAdapter(Activity activity, LoadFinishCallBack loadFinisCallBack, LoadResultCallBack loadResultCallBack) throws DbException {
        mActivity = activity;
        mLoadFinisCallBack = loadFinisCallBack;
        mLoadResultCallBack = loadResultCallBack;
        list = new ArrayList<>();
        ImageLoadProxy.initImageLoader(activity);
        dataBaseCrete = new DataBaseCrete(activity);
    }

    private void setAnimation(View view,int position){
        if(position>lastPosition){
            Animation animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.item_bottom_in);
            view.startAnimation(animation);
            lastPosition=position;
        }

    }

    @Override
    public void onViewDetachedFromWindow(VideoViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.card.clearAnimation();
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);

        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        final Video.DataBean bean = list.get(position);
        if (bean.getGroup()!=null){
            holder.videoplayer.setUp(bean.getGroup().getMp4_url(), bean.getGroup().getTitle());
            ImageLoadProxy.displayHeadIcon(Video.coverurl+bean.getGroup().getCover_image_uri(),holder.videoplayer.ivThumb);
            holder.tvAuthor.setText(bean.getGroup().getUser().getName());
            holder.tvTime.setText(String2TimeUtil.timeToStr(bean.getGroup().getCreate_time()));
            holder.tvLike.setText(bean.getGroup().getDigg_count());
            holder.tvCommentCount.setText(bean.getGroup().getComment_count());
            holder.tvUnlike.setText(bean.getGroup().getBury_count());
        }else {
            holder.videoplayer.setUp(Video.lckmp4url, "我只是想为女神买个避孕药！！为什么会遇到电视台直播？");
            ImageLoadProxy.displayHeadIcon(Video.coverImg,holder.videoplayer.ivThumb);
        }
        holder.imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(mActivity)
                        .title(R.string.app_name)
                        .titleColor(MyApplication.COLOR_OF_DIALOG_CONTENT)
                        .items(R.array.joke_dialog)
                        .backgroundColor(mActivity.getResources().getColor(MyApplication.COLOR_OF_DIALOG))
                        .contentColor(MyApplication.COLOR_OF_DIALOG_CONTENT)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {

                                switch (which) {
                                    //分享
                                    case 0:
                                        ShareUtil.shareText(mActivity, bean.getGroup().getContent().trim());
                                        break;
                                    //复制
                                    case 1:
                                        TextUtil.copy(mActivity, bean.getGroup().getContent());
                                        break;
                                }

                            }
                        }).show();
            }
        });



        setAnimation(holder.card, position);
    }

    public void loadFirst() throws DbException {
        page = 1;
        loadDataByNetworkType();
    }

    public void loadNextPage() throws DbException {
        page++;
        loadDataByNetworkType();
    }

    private void loadDataByNetworkType() throws DbException {

        if (NetWorkUtil.isNetWorkConnected(mActivity)) {
            loadData();
        } else {
            loadCache();
        }

    }


    private void loadData() {
        MyHttpUtils.activitySendHttpClientGet(Video.url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                try {
                    JSONObject json = new JSONObject(responseInfo.result);
                    JSONObject data = json.getJSONObject("data");

                    Video video = GsonUtil.jsonToBean(data.toString(), Video.class);
                    if(page==1){
                        list.clear();
                    }
                    list.addAll(video.getData());
                    notifyDataSetChanged();
                    mLoadResultCallBack.onSuccess();
                    mLoadFinisCallBack.loadFinish(null);

                    //缓存
                    SaveDataBase(data.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (DbException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(HttpException error, String msg) {
                mLoadResultCallBack.onError();
                mLoadFinisCallBack.loadFinish(null);
            }
        });
    }
    /**
     *  缓存数据,保存数据库
     * @param request
     * @throws DbException
     */
    private void SaveDataBase(String request) throws DbException {
        dataBaseCrete = new DataBaseCrete(mActivity);
        dataBaseCrete.delete(page, Constants.menu5);

        DataBase data = new DataBase();
        data.setId(page);
        data.setRequest(request);
        data.setPage(page);
        data.setMenuNumber(Constants.menu5);
        dataBaseCrete.sava(data);
    }
    private void loadCache() throws DbException {
        if(dataBaseCrete==null){
            dataBaseCrete = new DataBaseCrete(mActivity);
        }
        DataBase db = dataBaseCrete.findPage(page, Constants.menu5);
        if(null!=db){
            String request = db.getRequest();
            Video video = GsonUtil.jsonToBean(request, Video.class);


            list.addAll(video.getData());
            notifyDataSetChanged();
            mLoadResultCallBack.onSuccess();
            mLoadFinisCallBack.loadFinish(null);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.tv_author)
        TextView tvAuthor;
        @InjectView(R.id.tv_time)
        TextView tvTime;
        @InjectView(R.id.videoplayer)
        JCVideoPlayer videoplayer;
        @InjectView(R.id.tv_comments_name)
        TextView tvCommentsName;
        @InjectView(R.id.tv_comments_content)
        TextView tvCommentsContent;
        @InjectView(R.id.tv_support_des)
        TextView tvSupportDes;
        @InjectView(R.id.tv_like)
        TextView tvLike;
        @InjectView(R.id.ll_support)
        LinearLayout llSupport;
        @InjectView(R.id.tv_un_support_des)
        TextView tvUnSupportDes;
        @InjectView(R.id.tv_unlike)
        TextView tvUnlike;
        @InjectView(R.id.ll_unsupport)
        LinearLayout llUnsupport;
        @InjectView(R.id.tv_comment_count)
        TextView tvCommentCount;
        @InjectView(R.id.ll_comment)
        LinearLayout llComment;
        @InjectView(R.id.img_share)
        ImageView imgShare;
        @InjectView(R.id.bottom)
        RelativeLayout bottom;
        @InjectView(R.id.card)
        CardView card;

        public VideoViewHolder(View contentView) {
            super(contentView);
            ButterKnife.inject(this, contentView);

        }
    }


}
