package com.example.chaokun.neihanduanzi.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.chaokun.neihanduanzi.R;
import com.example.chaokun.neihanduanzi.adapte.JokeAdapter;
import com.example.chaokun.neihanduanzi.adapte.MusicAdapter;
import com.example.chaokun.neihanduanzi.adapte.VideoAdapter;
import com.example.chaokun.neihanduanzi.base.BaseFragment;
import com.example.chaokun.neihanduanzi.callback.LoadMoreListener;
import com.example.chaokun.neihanduanzi.callback.LoadResultCallBack;
import com.example.chaokun.neihanduanzi.utils.ToastUtils;
import com.example.chaokun.neihanduanzi.view.AutoLoadRecyclerView;
import com.lidroid.xutils.exception.DbException;
import com.victor.loading.rotate.RotateLoading;

import butterknife.ButterKnife;
import butterknife.InjectView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class MusicFragment extends BaseFragment implements LoadResultCallBack {


    @InjectView(R.id.recycler_view)
    AutoLoadRecyclerView mRecyclerView;
    @InjectView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @InjectView(R.id.loading)
    RotateLoading loading;
    private MusicAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        JCVideoPlayer.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auto_load, container, false);
        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void loadMore() throws DbException {
                mAdapter.loadNextPage();
            }
        });

        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    mAdapter.loadFirst();
                } catch (DbException e) {
                    e.printStackTrace();
                }

            }
        });

        try {
            mAdapter = new MusicAdapter(getActivity(), mRecyclerView, this);
        } catch (DbException e) {
            e.printStackTrace();
        }
        mRecyclerView.setAdapter(mAdapter);
        try {
            mAdapter.loadFirst();
        } catch (DbException e) {
            e.printStackTrace();
        }

        loading.start();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_refresh, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_refresh) {
            mSwipeRefreshLayout.setRefreshing(true);
            try {
                mAdapter.loadFirst();
            } catch (DbException e) {
                e.printStackTrace();
            }

            return true;
        }

        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onSuccess() {
        loading.stop();
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onError() {
        loading.stop();
        ToastUtils.showLong(context,LOAD_FAILED);
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }
}
