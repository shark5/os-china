package com.cjp.os_china.network;

import android.content.Context;

import com.cjp.os_china.BuildConfig;
import com.cjp.os_china.entity.BannerResult;
import com.cjp.os_china.entity.BaseResult;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class Api {
    final ApiService apiService;

    Api() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(60, TimeUnit.SECONDS);
        httpClientBuilder.networkInterceptors().add(
                new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder req = chain.request().newBuilder();
                        return chain.proceed(req.build());
                    }
                }
        );

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.interceptors().add(interceptor);
        }

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();

        Retrofit retrofit = retrofitBuilder
                .baseUrl(ApiService.BASE_API_URL)
                .client(httpClientBuilder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final Api INSTANCE = new Api();
    }

    //获取单例
    public static Api getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    public static class HttpResultFunc<T> implements Func1<BaseResult<T>, T> {

        @Override
        public T call(BaseResult<T> httpResult) {
            if (httpResult.getCode() != 0) {
//                throw new ApiException(httpResult.getCode());
            }
            return httpResult.getResult();
        }
    }

    //添加线程管理并订阅
    public static Subscription toSubscribe(Observable o, Subscriber s){
        return o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
