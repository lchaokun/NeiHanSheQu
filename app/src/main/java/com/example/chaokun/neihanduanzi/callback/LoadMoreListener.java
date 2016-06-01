package com.example.chaokun.neihanduanzi.callback;

import com.lidroid.xutils.exception.DbException;

/**
 * Created by zhaokaiqiang on 15/11/7.
 */
public interface LoadMoreListener {
    void loadMore() throws DbException;
}
