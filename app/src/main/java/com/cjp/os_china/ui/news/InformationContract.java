package com.cjp.os_china.ui.news;

import com.cjp.os_china.base.mvp.BaseModel;
import com.cjp.os_china.base.mvp.BasePresenter;
import com.cjp.os_china.base.mvp.BaseView;
import com.cjp.os_china.entity.BannerResult;
import com.cjp.os_china.network.SubscriberOnNextListener;

import rx.Subscription;

/**
 * Created by panj on 2016/12/19.
 */

public interface InformationContract {

    interface Model extends BaseModel {
        Subscription getBannerList(SubscriberOnNextListener<BannerResult> listener, int catalog);
    }

    interface View extends BaseView {
        void setBannerList(BannerResult result);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getBannerList();
    }
}
