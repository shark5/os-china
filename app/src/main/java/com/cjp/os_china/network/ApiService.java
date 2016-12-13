package com.cjp.os_china.network;

import com.cjp.os_china.entity.BannerResult;
import com.cjp.os_china.entity.BaseResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {

    /**
     * 根地址
     */
    String BASE_API_URL = "https://www.oschina.net/";

    //************************** User Part *****************************

    @GET("action/apiv2/banner")
    Observable<BaseResult<BannerResult>> getBannerList(@Query("catalog") int catalog);

}
