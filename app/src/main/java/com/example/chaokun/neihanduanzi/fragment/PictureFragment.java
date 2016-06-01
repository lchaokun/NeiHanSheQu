package com.example.chaokun.neihanduanzi.fragment;

import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.chaokun.neihanduanzi.R;
import com.example.chaokun.neihanduanzi.adapte.PictureAdapter;
import com.example.chaokun.neihanduanzi.base.BaseFragment;
import com.example.chaokun.neihanduanzi.bean.Picture;
import com.example.chaokun.neihanduanzi.callback.LoadFinishCallBack;
import com.example.chaokun.neihanduanzi.callback.LoadMoreListener;
import com.example.chaokun.neihanduanzi.callback.LoadResultCallBack;
import com.example.chaokun.neihanduanzi.utils.ImageLoadProxy;
import com.example.chaokun.neihanduanzi.utils.JDMediaScannerConnectionClient;
import com.example.chaokun.neihanduanzi.utils.ToastUtils;
import com.example.chaokun.neihanduanzi.view.AutoLoadRecyclerView;
import com.lidroid.xutils.exception.DbException;
import com.victor.loading.rotate.RotateLoading;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PictureFragment extends BaseFragment  implements LoadResultCallBack,LoadFinishCallBack {
    @InjectView(R.id.recycler_view)
    AutoLoadRecyclerView mRecyclerView;
    @InjectView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @InjectView(R.id.loading)
    RotateLoading loading;
    private MediaScannerConnection connection;
    private PictureAdapter mAdapter;
    protected Picture.PictureType mType;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mType = Picture.PictureType.BoringPicture;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auto_load, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLoadMoreListener(new LoadMoreListener(){

            @Override
            public void loadMore() throws DbException {
                //加载更多
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
        mRecyclerView.setOnPauseListenerParams(false, true);
        mAdapter = new PictureAdapter(getActivity(),mType,this,mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setmSaveFileCallBack(this);
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
    public void onDestroy() {
        super.onDestroy();
        //清除内存缓存，避免由于内存缓存造成的图片显示不完整
        ImageLoadProxy.getImageLoader().clearMemoryCache();
    }

    @Override
    public void onSuccess() {
        loading.stop();
        if (mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onError() {
        loading.stop();
        if (mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void loadFinish(Object obj) {
        Bundle bundle = (Bundle) obj;
        boolean isSmallPic = bundle.getBoolean(DATA_IS_SIAMLL_PIC);
        String filePath = bundle.getString(DATA_FILE_PATH);
        File newFile = new File(filePath);
        JDMediaScannerConnectionClient connectionClient = new JDMediaScannerConnectionClient(isSmallPic,
                newFile);
        connection = new MediaScannerConnection(getActivity(), connectionClient);
        connectionClient.setMediaScannerConnection(connection);
        connection.connect();
    }
}