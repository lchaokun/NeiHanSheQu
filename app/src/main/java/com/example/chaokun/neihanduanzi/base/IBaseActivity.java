package com.example.chaokun.neihanduanzi.base;

import android.content.Context;
import android.view.View;

/**
 * Activity接口
 * @author linchaokun
 * @version 1.0
 *
 */
public interface IBaseActivity {

	/**
	 * 绑定渲染视图的布局文件
	 * @return 布局文件资源id
	 */
	public int bindLayout();
	
	/**
	 * 初始化控件
	 */
	public void initView(final View view);
	
	/**
	 * 业务处理操作（onCreate方法中调用）
	 * @param mContext  当前Activity对象
	 */
	public void doBusiness(Context mContext);
	
	
	
}
