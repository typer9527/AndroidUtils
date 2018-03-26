package com.yl.androidutils.app.view;

import com.yl.androidutils.app.model.CaptChaBean;
import com.yl.androidutils.common.common.HttpRespond;

/**
 * Created by Yangli on 2018/3/26.
 */

public interface TestView {
    void showCaptchaPic(HttpRespond<CaptChaBean> respond);
}
