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
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.chaokun.neihanduanzi.R;
import com.example.chaokun.neihanduanzi.base.MyApplication;
import com.example.chaokun.neihanduanzi.bean.Joke;
import com.example.chaokun.neihanduanzi.callback.LoadFinishCallBack;
import com.example.chaokun.neihanduanzi.callback.LoadResultCallBack;
import com.example.chaokun.neihanduanzi.utils.GsonUtil;
import com.example.chaokun.neihanduanzi.utils.MyHttpUtils;
import com.example.chaokun.neihanduanzi.utils.NetWorkUtil;
import com.example.chaokun.neihanduanzi.utils.ShareUtil;
import com.example.chaokun.neihanduanzi.utils.String2TimeUtil;
import com.example.chaokun.neihanduanzi.utils.TextUtil;
import com.example.chaokun.neihanduanzi.utils.ToastUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    private int page;
    private int lastPosition = -1;
    private List<Joke.DataBean> list;
    private Activity mActivity;
    private LoadResultCallBack mLoadResultCallBack;
    private LoadFinishCallBack mLoadFinisCallBack;

    public JokeAdapter(Activity activity, LoadFinishCallBack loadFinisCallBack, LoadResultCallBack loadResultCallBack) {
        mActivity = activity;
        mLoadFinisCallBack = loadFinisCallBack;
        mLoadResultCallBack = loadResultCallBack;
        list = new ArrayList<>();
    }

    protected void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R
                    .anim.item_bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(JokeViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.card.clearAnimation();
    }

    @Override
    public JokeViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_joke, parent, false);
        return new JokeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final JokeViewHolder holder, final int position) {

        final Joke.DataBean bean = list.get(position);
        if(bean.getGroup()!=null){
            holder.tv_content.setText(bean.getGroup().getContent());
            holder.tv_author.setText(bean.getGroup().getUser().getName());
            holder.tv_time.setText(String2TimeUtil.timeToStr(bean.getGroup().getCreate_time()));
            holder.tv_like.setText(bean.getGroup().getDigg_count());
            holder.tv_comment_count.setText(bean.getGroup().getComment_count());
            holder.tv_unlike.setText(bean.getGroup().getBury_count());
        }


        holder.img_share.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public int getItemCount() {
        return list.size();
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
            loadData();
        } else {
            loadCache();
        }

    }

    private void loadData() {
        MyHttpUtils.activitySendHttpClientGet(Joke.url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                try {
                    JSONObject object = new JSONObject(responseInfo.result);
                    JSONObject data = object.getJSONObject("data");

                    Joke joke = GsonUtil.jsonToBean(data.toString(), Joke.class);
                    if(page==1){
                        list.clear();
                    }

                    list.addAll(joke.getData());
                    notifyDataSetChanged();
                    mLoadResultCallBack.onSuccess();
                    mLoadFinisCallBack.loadFinish(null);
                } catch (Exception e) {
                    e.printStackTrace();

                }

            }

            @Override
            public void onFailure(HttpException error, String msg) {
                ToastUtils.showErr(mActivity);
                mLoadResultCallBack.onError();
                mLoadFinisCallBack.loadFinish(null);
            }
        });

    }

    private void loadCache() {
      /*  mLoadFinisCallBack.loadFinish(null);
        mLoadResultCallBack.onSuccess(LoadResultCallBack.SUCCESS_OK, null);
        JokeCache jokeCacheUtil = JokeCache.getInstance(mActivity);
        if (page == 1) {
            mJokes.clear();
            ShowToast.Short(ConstantString.LOAD_NO_NETWORK);
        }
        mJokes.addAll(jokeCacheUtil.getCacheByPage(page));
        notifyDataSetChanged();*/
    }

//    private void getCommentCounts(final ArrayList<Joke> jokes) {

       /* StringBuilder sb = new StringBuilder();
        for (Joke joke : jokes) {
            sb.append("comment-" + joke.getComment_ID() + ",");
        }

        String url = sb.toString();
        if (url.endsWith(",")) {
            url = url.substring(0, url.length() - 1);
        }

        RequestManager.addRequest(new Request4CommentCounts(CommentNumber.getCommentCountsURL(url), new Response
                .Listener<ArrayList<CommentNumber>>() {

            @Override
            public void onResponse(ArrayList<CommentNumber> response) {

                for (int i = 0; i < jokes.size(); i++) {
                    jokes.get(i).setComment_counts(response.get(i).getComments() + "");
                }

                if (page == 1) {
                    mJokes.clear();
                    //首次正常加载之后，清空之前的缓存
                    JokeCache.getInstance(mActivity).clearAllCache();
                }

                mJokes.addAll(jokes);
                notifyDataSetChanged();

                //加载完毕后缓存
                JokeCache.getInstance(mActivity).addResultCache(JSONParser.toString(jokes),
                        page);
                mLoadFinisCallBack.loadFinish(null);
                mLoadResultCallBack.onSuccess(LoadResultCallBack.SUCCESS_OK, null);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mLoadResultCallBack.onError(LoadResultCallBack.ERROR_NET, error.getMessage());
                mLoadFinisCallBack.loadFinish(null);
            }
        }
        ), mActivity);*/

//    }

    public static class JokeViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_author;
        private TextView tv_time;
        private TextView tv_content;
        private TextView tv_like;
        private TextView tv_unlike;
        private TextView tv_comment_count;

        private ImageView img_share;
        private CardView card;
        private LinearLayout ll_comment;

        public JokeViewHolder(View contentView) {
            super(contentView);

            tv_author = (TextView) contentView.findViewById(R.id.tv_author);
            tv_content = (TextView) contentView.findViewById(R.id.tv_content);
            tv_time = (TextView) contentView.findViewById(R.id.tv_time);
            tv_like = (TextView) contentView.findViewById(R.id.tv_like);
            tv_unlike = (TextView) contentView.findViewById(R.id.tv_unlike);
            tv_comment_count = (TextView) contentView.findViewById(R.id.tv_comment_count);

            img_share = (ImageView) contentView.findViewById(R.id.img_share);
            card = (CardView) contentView.findViewById(R.id.card);
            ll_comment = (LinearLayout) contentView.findViewById(R.id.ll_comment);
        }
    }

}

