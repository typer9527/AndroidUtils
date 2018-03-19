package com.yl.androidutils.utils.webview;

import android.webkit.WebView;


public interface IndicatorController {

    void progress(WebView v, int newProgress);

    BaseProgressSpec offerIndicator();
}
