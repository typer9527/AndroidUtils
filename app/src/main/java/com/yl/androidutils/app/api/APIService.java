package com.yl.androidutils.app.api;

import com.yl.androidutils.app.model.CaptChaBean;
import com.yl.androidutils.common.common.HttpRespond;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/3/1.
 */

public interface APIService {

    @GET(APIFactory.CAPTCHA_URL)
    Observable<HttpRespond<CaptChaBean>> getCaptchaUrl(
            @Query("client") String client,
            @Query("package") String packageName,
            @Query("ver") String ver);
}
