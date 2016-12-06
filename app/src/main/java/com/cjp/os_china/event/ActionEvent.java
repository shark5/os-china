package com.cjp.os_china.event;


/**
 * Created by panj on 2016/6/19.
 */
public class ActionEvent<T> {
    private static int EVENT_BASE = 100;
    public static int EVENT_MAIN_ACTIVITY_NAVIGATE_TO = EVENT_BASE + 1;

    private int mAction;
    private T mObject;

    public ActionEvent(int action) {
        this.mAction = action;
    }

    public ActionEvent(T object, int action) {
        this.mObject = object;
        this.mAction = action;
    }

    public int getAction() {
        return mAction;
    }

    public void setAction(int action) {
        this.mAction = action;
    }

    public T getObject() {
        return mObject;
    }

    public void setObject(T object) {
        this.mObject = object;
    }
}
