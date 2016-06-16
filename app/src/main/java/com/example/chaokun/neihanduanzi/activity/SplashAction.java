package com.example.chaokun.neihanduanzi.activity;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.chaokun.neihanduanzi.R;
import com.example.chaokun.neihanduanzi.base.BaseActivity;

/**
 * 启动页面
 */
public class SplashAction extends BaseActivity {



    @Override
    public int bindLayout() {
        return R.layout.activity_splash_action;
    }

    @Override
    public void initView(View view) {
        new Thread(){
            public void run() {
                SystemClock.sleep(3000);

                Intent intent = new Intent();
                intent.setClass(SplashAction.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }.start();
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
