package com.cjp.os_china.ui.news;

import com.cjp.os_china.entity.BannerResult;
import com.cjp.os_china.network.Api;
import com.cjp.os_china.network.ProgressSubscriber;
import com.cjp.os_china.network.SubscriberOnNextListener;

import rx.Observable;
import rx.Subscription;

/**
 * Created by panj on 2016/12/19.
 */

public class InformationModel implements InformationContract.Model {

    public Subscription getBannerList(SubscriberOnNextListener<BannerResult> listener, int catalog) {
        Observable observable = Api.getInstance().getApiService().getBannerList(catalog)
                .map(new Api.HttpResultFunc<BannerResult>());

        return Api.toSubscribe(observable, new ProgressSubscriber<BannerResult>(listener));
    }
}
