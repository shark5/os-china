package com.cjp.os_china.base;

import android.os.Bundle;

import com.cjp.os_china.base.mvp.BaseModel;
import com.cjp.os_china.base.mvp.BasePresenter;
import com.cjp.os_china.base.mvp.BaseView;
import com.cjp.os_china.util.TUtil;

/**
 * Created by panj on 2016/12/19.
 */

public abstract class BaseMvpFragment<P extends BasePresenter, M extends BaseModel> extends BaseFragment implements BaseView {

    public P mPresenter;

    public M mModel;

    abstract protected int getLayoutResId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (this instanceof BaseView) {
            mPresenter.setVM(this, mModel);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
    }

    @Override
    public void onInternetError() {
//        showShortToast("网络异常");
    }

    @Override
    public void onRequestError(String msg) {
//        showShortToast(msg);
//        JLog.e("REQUEST_ERROR ==== ", msg);
    }

    @Override
    public void onRequestStart() {

    }

    @Override
    public void onRequestEnd() {

    }
}
