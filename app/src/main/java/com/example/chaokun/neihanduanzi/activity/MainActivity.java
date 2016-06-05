package com.example.chaokun.neihanduanzi.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.chaokun.neihanduanzi.R;
import com.example.chaokun.neihanduanzi.base.BaseActivity;
import com.example.chaokun.neihanduanzi.fragment.FreshNewsFragment;
import com.example.chaokun.neihanduanzi.fragment.MainMenuFragment;
import com.example.chaokun.neihanduanzi.utils.ToastUtils;

import butterknife.InjectView;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.frame_container)
    FrameLayout frameContainer;
    @InjectView(R.id.drawer_container)
    FrameLayout drawerContainer;
    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private long exitTime;
    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name,
                R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };
        mActionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mActionBarDrawerToggle);

        replaceFragment(R.id.frame_container, new FreshNewsFragment());
        replaceFragment(R.id.drawer_container, new MainMenuFragment());
    }


    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void initdata() {
        super.initdata();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
               ToastUtils.showLong(context,"再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    ///////////////////////////////////////////////////////////////////////////
    // Drawer Method
    ///////////////////////////////////////////////////////////////////////////



    public void closeDrawer() {
        drawerLayout.closeDrawers();
    }
}
