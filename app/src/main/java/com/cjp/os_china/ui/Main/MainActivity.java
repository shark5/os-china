package com.cjp.os_china.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.cjp.os_china.R;
import com.cjp.os_china.base.AppDefs;
import com.cjp.os_china.base.BaseActivity;
import com.cjp.os_china.event.ActionEvent;
import com.cjp.os_china.event.IEventBus;
import com.cjp.os_china.ui.explore.ExploreFragment;
import com.cjp.os_china.ui.my.MyFragment;
import com.cjp.os_china.ui.news.NewsFragment;
import com.cjp.os_china.ui.tweet.TweetFragment;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity implements IEventBus {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    protected void initViews() {
        setFragment(AppDefs.MAIN_ACTIVITY_NAVIGATE_TO_INFORMATION);
    }

    @Subscribe
    public void onEvent(ActionEvent event) {
        if (event != null) {
            if (event.getAction() == ActionEvent.EVENT_MAIN_ACTIVITY_NAVIGATE_TO) {
                setFragment((int) event.getObject());
            }
        }
    }

    private void setFragment(int which) {
        Fragment fragment;
        switch (which) {
            case AppDefs.MAIN_ACTIVITY_NAVIGATE_TO_INFORMATION:
                fragment = new NewsFragment();
                break;
            case AppDefs.MAIN_ACTIVITY_NAVIGATE_TO_BLOG:
                fragment = new TweetFragment();
                break;
            case AppDefs.MAIN_ACTIVITY_NAVIGATE_TO_ANSWER:
                fragment = new ExploreFragment();
                break;
            case AppDefs.MAIN_ACTIVITY_NAVIGATE_TO_ACTIVTTY:
                fragment = new MyFragment();
                break;
            default:
                fragment = new NewsFragment();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contains, fragment);
        transaction.commit();
    }

}
