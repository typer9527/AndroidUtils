package com.yl.androidutils.app.presenter;

import android.util.Log;

import com.yl.androidutils.app.model.CaptChaBean;
import com.yl.androidutils.app.view.TestView;
import com.yl.androidutils.common.base.BasePresent;
import com.yl.androidutils.common.common.Constants;
import com.yl.androidutils.common.common.HttpRespond;
import com.yl.androidutils.common.rxbase.RetrofitFactory;

import io.reactivex.functions.Consumer;

/**
 * Created by Yangli on 2018/3/26.
 */

public class TestPresenter extends BasePresent<TestView> {
    private static final String TAG = "TestPresenter";

    public void getCaptcha() {
        add(RetrofitFactory.getInstance().getApiService().getCaptchaUrl(Constants.CLIENT,
                Constants.PACKAGE, Constants.VER), new Consumer<HttpRespond<CaptChaBean>>() {
            @Override
            public void accept(HttpRespond<CaptChaBean> captChaBeanHttpRespond) throws Exception {
                Log.e(TAG, "accept: " + captChaBeanHttpRespond.data.captchaUrl);
                view.showCaptchaPic(captChaBeanHttpRespond);
            }
        });
    }
}
