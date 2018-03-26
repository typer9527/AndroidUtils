package com.yl.androidutils.common.rxbase;

import com.yl.androidutils.app.api.APIFactory;
import com.yl.androidutils.app.api.APIService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/3/1.
 */

public class RetrofitFactory {

    private static final int TIME_OUT = 5;
    private static APIService apiService;
    private static RetrofitFactory retrofitFactory;

    private RetrofitFactory() {
        /**
         * 构造函数私有化
         * 并在构造函数中进行retrofit的初始化
         */
        OkHttpClient client = new OkHttpClient();
        client.newBuilder().connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        /**
         * 由于retrofit底层的实现是通过okhttp实现的，所以可以通过okHttp来设置一些连接参数
         * 如超时等
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIFactory.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(APIService.class);
    }

    public static RetrofitFactory getInstance() {
        if (retrofitFactory == null) {
            synchronized (RetrofitFactory.class) {
                if (retrofitFactory == null)
                    retrofitFactory = new RetrofitFactory();
            }

        }
        return retrofitFactory;
    }

    public APIService getApiService() {
        return apiService;
    }

}
