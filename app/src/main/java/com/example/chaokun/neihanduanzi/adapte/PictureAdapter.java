package com.example.chaokun.neihanduanzi.adapte;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.chaokun.neihanduanzi.R;
import com.example.chaokun.neihanduanzi.bean.CommentNumber;
import com.example.chaokun.neihanduanzi.bean.Picture;
import com.example.chaokun.neihanduanzi.callback.LoadResultCallBack;
import com.example.chaokun.neihanduanzi.fragment.PictureFragment;
import com.example.chaokun.neihanduanzi.utils.GsonUtil;
import com.example.chaokun.neihanduanzi.utils.ImageLoadProxy;
import com.example.chaokun.neihanduanzi.utils.MyHttpUtils;
import com.example.chaokun.neihanduanzi.utils.NetWorkUtil;
import com.example.chaokun.neihanduanzi.utils.String2TimeUtil;
import com.example.chaokun.neihanduanzi.utils.ToastUtils;
import com.example.chaokun.neihanduanzi.view.ShowMaxImageView;
import com.google.gson.JsonObject;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.PictureViewHolder> {

    private int page;
    private int lastPosition = -1;
    private ArrayList<Picture.CommentsBean> pictures;
    private Activity mActivity;
    private Picture.PictureType mType;
    private boolean isWifiConnected;
    private LoadResultCallBack mLoadCallBack;

    public PictureAdapter(Activity activity, Picture.PictureType type,LoadResultCallBack loadCallBack) {
        mActivity = activity;
        pictures = new ArrayList<>();
        this.mType=type;
        isWifiConnected = NetWorkUtil.isWifiConnected(mActivity);
        ImageLoadProxy.initImageLoader(activity);
        this.mLoadCallBack=loadCallBack;
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R
                    .anim.item_bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(PictureViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.card.clearAnimation();
    }

    public void loadFirst() {
        page = 1;
        loadDataByNetworkType();
    }

    public void loadNextPage() {
        page++;
        loadDataByNetworkType();
    }

    private void loadDataByNetworkType() {

        if (NetWorkUtil.isNetWorkConnected(mActivity)) {
            //有网络加载网络数据
            loadData();
        } else {
            //无网络加载缓存数据
//            loadCache();
        }
    }

    private void loadData() {

        MyHttpUtils.activitySendHttpClientGet(Picture.getRequestUrl(mType,page), new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                Picture picture = GsonUtil.jsonToBean(responseInfo.result,Picture.class);
                if (page==1){
                    pictures.clear();
                }
                pictures.addAll(picture.getComments());

                //每次加载后缓存


                //获取评论
                getCommentNumber();
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                ToastUtils.showLong(mActivity,"网络错误");
            }
        });

    }

    private void getCommentNumber(){
       final StringBuilder sb = new StringBuilder();
        for (Picture.CommentsBean joke : pictures) {
            sb.append("comment-" + joke.getComment_ID() + ",");
        }

        MyHttpUtils.activitySendHttpClientGet(CommentNumber.getCommentCountsURL(sb.toString()), new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                try {
                    JSONObject object = new JSONObject(responseInfo.result);
                    JSONObject res = object.getJSONObject("response");
                    String[] comment_IDs = getRequestUrl().split("\\=")[1].split("\\,");
                    ArrayList<CommentNumber> commentNumbers = new ArrayList<>();
                    for (String comment_ID : comment_IDs) {

                        if (!res.isNull(comment_ID)) {
                            CommentNumber commentNumber = new CommentNumber();
                            commentNumber.setComments(res.getJSONObject(comment_ID).getInt(CommentNumber.COMMENTS));
                            commentNumber.setThread_id(res.getJSONObject(comment_ID).getString(CommentNumber.THREAD_ID));
                            commentNumber.setThread_key(res.getJSONObject(comment_ID).getString(CommentNumber.THREAD_KEY));
                            commentNumbers.add(commentNumber);
                        } else {
                            //可能会出现没有对应id的数据的情况，为了保证条数一致，添加默认数据
                            commentNumbers.add(new CommentNumber("0", "0", 0));
                        }
                    }

                    for (int i = 0; i <pictures.size() ; i++) {
                        pictures.get(i).setComment_counts(commentNumbers.get(i).getComments());
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
                notifyDataSetChanged();
                mLoadCallBack.onSuccess();
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                ToastUtils.showErr(mActivity);
                mLoadCallBack.onError();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    @Override
    public void onBindViewHolder(final PictureViewHolder holder, int position) {
        Picture.CommentsBean bean = pictures.get(position);
        String picUrl = bean.getPics().get(0);
        if (picUrl.endsWith(".gif")) {
            holder.img_gif.setVisibility(View.VISIBLE);
            //非WIFI网络情况下，GIF图只加载缩略图，详情页才加载真实图片
            if (!isWifiConnected) {
                picUrl = picUrl.replace("mw600", "small").replace("mw1200", "small").replace
                        ("large", "small");
            }
        } else {
            holder.img_gif.setVisibility(View.GONE);
        }
        holder.progress.setProgress(0);
        holder.progress.setVisibility(View.VISIBLE);

        ImageLoadProxy.displayImageList(picUrl, holder.img, R.mipmap.ic_loading_large_1, new
                        SimpleImageLoadingListener() {
                            @Override
                            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                                super.onLoadingComplete(imageUri, view, loadedImage);
                                holder.progress.setVisibility(View.GONE);
                            }
                        },
                new ImageLoadingProgressListener() {
                    @Override
                    public void onProgressUpdate(String imageUri, View view, int current, int total) {
                        holder.progress.setProgress((int) (current * 100f / total));
                    }
                });
        if (TextUtils.isEmpty(bean.getText_content().trim())) {
            holder.tv_content.setVisibility(View.GONE);
        } else {
            holder.tv_content.setVisibility(View.VISIBLE);
            holder.tv_content.setText(bean.getText_content().trim());
        }

        holder.tv_author.setText(bean.getComment_author());
        holder.tv_time.setText(String2TimeUtil.dateString2GoodExperienceFormat(bean.getComment_date()));
        holder.tv_like.setText(bean.getVote_positive());
        holder.tv_unlike.setText(bean.getVote_negative());
        holder.tv_comment_count.setText(bean.getComment_counts()+"");


        setAnimation(holder.card, position);
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pic,parent,false);
        return new PictureViewHolder(view);
    }

    public static class PictureViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.tv_author)
        TextView tv_author;
        @InjectView(R.id.tv_time)
        TextView tv_time;
        @InjectView(R.id.tv_content)
        TextView tv_content;
        @InjectView(R.id.tv_like)
        TextView tv_like;
        @InjectView(R.id.tv_unlike)
        TextView tv_unlike;
        @InjectView(R.id.tv_comment_count)
        TextView tv_comment_count;
        @InjectView(R.id.tv_unsupport_des)
        TextView tv_un_support_des;
        @InjectView(R.id.tv_support_des)
        TextView tv_support_des;

        @InjectView(R.id.img_share)
        ImageView img_share;
        @InjectView(R.id.img_gif)
        ImageView img_gif;
        @InjectView(R.id.img)
        ShowMaxImageView img;

        @InjectView(R.id.ll_comment)
        LinearLayout ll_comment;
        @InjectView(R.id.progress)
        ProgressBar progress;
        @InjectView(R.id.card)
        CardView card;

        public PictureViewHolder(View contentView) {
            super(contentView);
            ButterKnife.inject(this, contentView);
        }
    }
}