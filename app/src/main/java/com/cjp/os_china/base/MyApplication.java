package com.cjp.os_china.base;

import android.app.Application;

import com.cjp.os_china.BuildConfig;
import com.jiongbull.jlog.Logger;
import com.jiongbull.jlog.constant.LogLevel;
import com.jiongbull.jlog.constant.LogSegment;
import com.jiongbull.jlog.util.TimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panj on 2016/12/19.
 */

public class MyApplication extends Application {

    private static Logger sLogger;

    public MyApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationDelegate.getInstance().setApplication(this);
        initLogger();
    }

    private void initLogger() {
        List<String> logLevels = new ArrayList<>();
        logLevels.add(LogLevel.ERROR);
        logLevels.add(LogLevel.WTF);

        sLogger = Logger.Builder.newBuilder(getApplicationContext(), "jlog")
                /* properties below are default value, you can modify them or not. */
                .setDebug(BuildConfig.DEBUG)
                .setWriteToFile(false)
                .setLogDir("jlog")
                .setLogPrefix("")
                .setLogSegment(LogSegment.TWELVE_HOURS)
                .setLogLevelsForFile(logLevels)
                .setZoneOffset(TimeUtils.ZoneOffset.P0800)
                .setTimeFormat("yyyy-MM-dd HH:mm:ss")
                .setPackagedLevel(0)
                .setStorage(null)
                .build();
    }

    public static Logger getLogger() {
        return sLogger;
    }
}
