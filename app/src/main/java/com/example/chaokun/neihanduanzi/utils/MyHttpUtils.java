package com.example.chaokun.neihanduanzi.utils;

import java.util.HashMap;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * 项目名称：intelligen_tourism
 * 
 * @author 林朝昆 E-mail:812086325@qq.com
 * @date 创建时间：2015-10-12 下午4:27:06
 * @version 1.0 文件名称：MyHttpUtils.java
 */
public class MyHttpUtils {

	private static HttpUtils http;

	/**
	 * Android Activity发起的 使用com.lidroid.xutils.HttpUtils的send方法发送异步POST请求
	 * 
	 * @param urlStr
	 *            请求地址
	 * @param paramMap
	 *            请求参数对（参数名-参数值）
	 * @param requestCallBack
	 *            回调方法
	 * @return
	 */
	public static void activitySendHttpClientPost(String urlStr,
			HashMap<String, String> paramMap,
			RequestCallBack<String> requestCallBack) {
		RequestParams params = new RequestParams();
		if (null != paramMap) {
			for (HashMap.Entry me : paramMap.entrySet()) {
				params.addQueryStringParameter((String) me.getKey(),
						(String) me.getValue());
			}
		}
		if (http == null) {
			http = new HttpUtils();

		}
		http.configTimeout(120000);// 设置超时时间
		http.send(HttpMethod.POST, urlStr, params, requestCallBack);

	}

	/**
	 * Android Activity发起的 使用com.lidroid.xutils.HttpUtils的send方法发送异步POST请求
	 *
	 * @param urlStr
	 *            请求地址
	 * @param requestCallBack
	 *            回调方法
	 * @return
	 */
	public static void activitySendHttpClientGet(String urlStr,RequestCallBack<String> requestCallBack) {

		if (http == null) {
			http = new HttpUtils();

		}
		http.configTimeout(120000);// 设置超时时间
		http.send(HttpMethod.POST, urlStr, requestCallBack);

	}


}
