package com.example.chaokun.neihanduanzi.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.chaokun.neihanduanzi.R;
import com.lidroid.xutils.ViewUtils;

import butterknife.ButterKnife;

/**
 * 整个activity的基类
 * 
 * @author linchaokun
 * 
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity {

	/** 当前Activity渲染的视图View **/
	public View mContextView = null;
	public Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 添加Activity到堆栈
		MyApplication.getInstance().addActivity(this);

		// 设置渲染视图View
		mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
		setContentView(mContextView);
		context = this;
		ViewUtils.inject(this);
		ButterKnife.inject(this);
		// 初始化控件
		initView(mContextView);
		// 初始化数据
		initdata();
		// 业务操作
		doBusiness(this);

	}
	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.anim_none, R.anim.trans_center_2_right);
	}
	public void initdata() {

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		// 结束Activity&从栈中移除该Activity
		MyApplication.getInstance().finishActivity(this);
	}

	public void tv_back(View view) {
		finish();
	}

	public void replaceFragment(int id_content, Fragment fragment) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(id_content, fragment);
		transaction.commit();
	}
}