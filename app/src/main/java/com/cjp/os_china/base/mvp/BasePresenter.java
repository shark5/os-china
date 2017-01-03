package com.cjp.os_china.base.mvp;

import android.content.Context;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by panj on 2016/12/19.
 */
public abstract class BasePresenter<M, V> {

    public Context context;
    public M mModel;
    public V mView;
    private CompositeSubscription mCompositeSubscription;

    public void setVM(V v, M m) {
        this.mView = v;
        this.mModel = m;
        this.mCompositeSubscription = new CompositeSubscription();
    }

    public void onDestroy() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.add(s);
        }
    }
}
