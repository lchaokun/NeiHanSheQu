package com.example.chaokun.neihanduanzi.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.chaokun.neihanduanzi.R;
import com.example.chaokun.neihanduanzi.base.MyApplication;
import com.example.chaokun.neihanduanzi.utils.AppInfoUtil;
import com.example.chaokun.neihanduanzi.utils.FileUtil;
import com.example.chaokun.neihanduanzi.utils.ToastUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.text.DecimalFormat;


/**
 * Created by linchaokun on 2016/6/17.
 */
public class SettingFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {
    public static final String CLEAR_CACHE = "clear_cache";
    public static final String ABOUT_APP = "about_app";
    public static final String APP_VERSION = "app_version";

    private Preference clearCache;
    private Preference aboutApp;
    private Preference appVersion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        clearCache = findPreference(CLEAR_CACHE);
        aboutApp = findPreference(ABOUT_APP);
        appVersion = findPreference(APP_VERSION);

        appVersion.setTitle("版本："+ AppInfoUtil.getVersionName(getActivity()));
        File cacheFile = ImageLoader.getInstance().getDiskCache().getDirectory();
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        clearCache.setSummary("缓存大小：" + decimalFormat.format(FileUtil.getDirSize(cacheFile)) + "M");

        clearCache.setOnPreferenceClickListener(this);
        aboutApp.setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();

        if (key.equals(CLEAR_CACHE)) {
            ImageLoader.getInstance().clearDiskCache();
            ToastUtils.showStr("清除缓存成功");
            clearCache.setSummary("缓存大小：0.00M");
        } else if (key.equals(ABOUT_APP)) {

            MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                    .title(R.string.app_name)
                    .backgroundColor(getResources().getColor(MyApplication.COLOR_OF_DIALOG))
                    .contentColor(MyApplication.COLOR_OF_DIALOG_CONTENT)
                    .positiveColor(MyApplication.COLOR_OF_DIALOG_CONTENT)
                    .negativeColor(MyApplication.COLOR_OF_DIALOG_CONTENT)
                    .neutralColor(MyApplication.COLOR_OF_DIALOG_CONTENT)
                    .titleColor(MyApplication.COLOR_OF_DIALOG_CONTENT)
                    .content("开发者：林朝昆\n开发时间：2016年6月\n由于时间问题功能界面不太完善，将在后期继续完善，如果您有好的建议可联系作者改进\nQQ：812086325 ^_^")
                    .positiveText("GitHub")
                    .negativeText("CoDing")
                    .neutralText("CSDN")
                    .callback(new MaterialDialog.ButtonCallback() {
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            super.onPositive(dialog);
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ZhaoKaiQiang/JianDan")));
                            dialog.dismiss();
                        }

                        @Override
                        public void onNegative(MaterialDialog dialog) {
                            super.onNegative(dialog);
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://coding.net/u/chaokun/p/NeiHanDuanZi/git")));
                        }

                        @Override
                        public void onNeutral(MaterialDialog dialog) {
                            super.onNeutral(dialog);
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/qq_23477421")));
                        }
                    })
                    .build();
            dialog.show();
        }
        return true;
    }
}
