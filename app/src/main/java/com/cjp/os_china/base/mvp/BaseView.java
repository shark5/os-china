package com.cjp.os_china.base.mvp;

/**
 * Created by panj on 2016/12/19.
 */
public interface BaseView {

    void onRequestStart();

    void onRequestError(String msg);

    void onRequestEnd();

    void onInternetError();
}
