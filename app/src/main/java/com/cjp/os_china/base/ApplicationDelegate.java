package com.cjp.os_china.base;

import android.app.Activity;
import android.app.Application;

/**
 * Created by panj on 2016/12/19.
 */

public class ApplicationDelegate {

    private Application mApplication;
    private Activity mTopActivity;

    private static class SingletonHolder {
        private static final ApplicationDelegate INSTANCE = new ApplicationDelegate();
    }

    public static ApplicationDelegate getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void setApplication(Application application) {
        mApplication = application;
    }

    public Application getApplication() {
        return mApplication;
    }

    public void setTopActivity(Activity topActivity) {
        this.mTopActivity = topActivity;
    }

    public Activity getTopActivity() {
        return mTopActivity;
    }
}
