package com.example.chaokun.neihanduanzi.base;

import java.util.Stack;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/**
 * 整个应用程序Applicaiton
 * @author linchaokun
 *
 */
public class MyApplication extends Application {  
      
    private static Stack<Activity> activityStack;  
    private static MyApplication singleton;
    private static Context mContext;
    @Override  
    public void onCreate()  
    {  
        super.onCreate();  
        singleton=this;
        mContext=this;
    }  
    // 获得application实例 
    public static MyApplication getInstance() {  
        return singleton;  
    }  
  
    /** 
     * add Activity 添加Activity到栈 
     */  
    public void addActivity(Activity activity){  
        if(activityStack ==null){  
            activityStack =new Stack<Activity>();  
        }  
        activityStack.add(activity);  
    }  
    /** 
     * get current Activity 获取当前Activity（栈中最后一个压入的） 
     */  
    public Activity currentActivity() {  
        Activity activity = activityStack.lastElement();  
        return activity;  
    }  
    /** 
     * 结束当前Activity（栈中最后一个压入的） 
     */  
    public void finishActivity() {  
        Activity activity = activityStack.lastElement();  
        finishActivity(activity);  
    }  
  
    /** 
     * 结束指定的Activity 
     */  
    public void finishActivity(Activity activity) {  
        if (activity != null) {  
            activityStack.remove(activity);  
            activity.finish();  
            activity = null;  
        }  
    }  
  
    /** 
     * 结束指定类名的Activity 
     */  
    public void finishActivity(Class<?> cls) {  
        for (Activity activity : activityStack) {  
            if (activity.getClass().equals(cls)) {  
                finishActivity(activity);  
            }  
        }  
    }  
  
    /** 
     * 结束所有Activity 
     */  
    public void finishAllActivity() {  
        for (int i = 0, size = activityStack.size(); i < size; i++) {  
            if (null != activityStack.get(i)) {  
                activityStack.get(i).finish();  
            }  
        }  
        activityStack.clear();  
    }  
  
    /** 
     * 退出应用程序 
     */  
    public void AppExit() {  
        try {  
            finishAllActivity();  
        } catch (Exception e) {  
        }  
    }  
  
}  