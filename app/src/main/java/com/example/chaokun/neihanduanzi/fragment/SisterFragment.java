package com.example.chaokun.neihanduanzi.fragment;

import android.os.Bundle;

import com.example.chaokun.neihanduanzi.bean.Picture;


public class SisterFragment extends PictureFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mType = Picture.PictureType.Sister;
    }
}
