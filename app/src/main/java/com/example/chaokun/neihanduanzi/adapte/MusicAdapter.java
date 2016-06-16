package com.example.chaokun.neihanduanzi.adapte;

import android.app.Activity;
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
import com.example.chaokun.neihanduanzi.bean.Music;
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
import com.example.chaokun.neihanduanzi.utils.ToastUtils;
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
public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {
    private int page;
    private int lastPosition = -1;
    private List<Music.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list;
    private Activity mActivity;
    private LoadResultCallBack mLoadResultCallBack;
    private LoadFinishCallBack mLoadFinisCallBack;
    private DataBaseCrete dataBaseCrete;

    private int allNum;

    public MusicAdapter(Activity activity, LoadFinishCallBack loadFinisCallBack, LoadResultCallBack loadResultCallBack) throws DbException {
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
    public void onViewDetachedFromWindow(MusicViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.card.clearAnimation();
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);

        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
       final Music.ShowapiResBodyBean.PagebeanBean.ContentlistBean bean = list.get(position);
        if (bean!=null){
            holder.videoplayer.setUp(bean.getVoice_uri(), bean.getText().trim().replaceAll("\\\\s*|\\t|\\r|\\n",""));
            ImageLoadProxy.displayHeadIcon(bean.getImage3(),holder.videoplayer.ivThumb);
            holder.tvAuthor.setText(bean.getName());
            holder.tvTime.setText(bean.getCreate_time());
            holder.tvLike.setText(bean.getLove());
            holder.tvCommentCount.setText(bean.getLove());
            holder.tvUnlike.setText(String.valueOf(bean.getHate()));
        }else {
            holder.videoplayer.setUp(Video.lckmp4url, "林朝昆个人视频\nQQ：812086325");
            ImageLoadProxy.displayHeadIcon(Video.lckimg,holder.videoplayer.ivThumb);
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
                                        ShareUtil.shareText(mActivity, bean.getVoice_uri());
                                        break;
                                    //复制
                                    case 1:
                                        TextUtil.copy(mActivity, bean.getVoice_uri());
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
        if (allNum>=page){
            page++;
            loadDataByNetworkType();
        }else{
            ToastUtils.showStr("暂无数据");
        }


    }

    private void loadDataByNetworkType() throws DbException {

        if (NetWorkUtil.isNetWorkConnected(mActivity)) {
            loadData();
        } else {
            loadCache();
        }

    }


    private void loadData() {
        MyHttpUtils.activitySendHttpClientGet(Music.url+page, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                try {


                    Music music = GsonUtil.jsonToBean(responseInfo.result, Music.class);
                    allNum = music.getShowapi_res_body().getPagebean().getAllNum();
                    if(page==1){
                        list.clear();
                    }

                    list.addAll(music.getShowapi_res_body().getPagebean().getContentlist());
                    notifyDataSetChanged();
                    mLoadResultCallBack.onSuccess();
                    mLoadFinisCallBack.loadFinish(null);

                    //缓存
                    SaveDataBase(responseInfo.result);
                } catch (Exception e) {
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
        dataBaseCrete.delete(page, Constants.menu1);

        DataBase data = new DataBase();
        data.setId(page);
        data.setRequest(request);
        data.setPage(page);
        data.setMenuNumber(Constants.menu1);
        dataBaseCrete.sava(data);
    }
    private void loadCache() throws DbException {
        if(dataBaseCrete==null){
            dataBaseCrete = new DataBaseCrete(mActivity);
        }
        DataBase db = dataBaseCrete.findPage(page, Constants.menu1);
        if(null!=db){
            String request = db.getRequest();
            Music music = GsonUtil.jsonToBean(request, Music.class);


            list.addAll(music.getShowapi_res_body().getPagebean().getContentlist());
            notifyDataSetChanged();
            mLoadResultCallBack.onSuccess();
            mLoadFinisCallBack.loadFinish(null);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MusicViewHolder extends RecyclerView.ViewHolder {
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

        public MusicViewHolder(View contentView) {
            super(contentView);
            ButterKnife.inject(this, contentView);

        }
    }


}
