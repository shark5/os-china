package com.cjp.os_china.base;

import android.app.Application;

/**
 * Created by panj on 2016/12/19.
 */

public class MyApplication extends Application {

    public MyApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationDelegate.getInstance().setApplication(this);
    }
}
