package com.cjp.os_china.ui.news;

import com.cjp.os_china.base.AppDefs;
import com.cjp.os_china.entity.BannerResult;
import com.cjp.os_china.network.SubscriberOnNextListener;

/**
 * Created by panj on 2016/12/19.
 */

public class InformationPresenterImpl extends InformationContract.Presenter {

    @Override
    public void getBannerList() {
        SubscriberOnNextListener<BannerResult> listener = new SubscriberOnNextListener<BannerResult>() {
            @Override
            public void onNext(BannerResult result) {
                BannerResult bannerResult = result;
                if (mView != null) {
                    mView.setBannerList(result);
                }
            }
        };
        addSubscription(mModel.getBannerList(listener, AppDefs.CATALOG_BANNER_NEWS));
    }
}
