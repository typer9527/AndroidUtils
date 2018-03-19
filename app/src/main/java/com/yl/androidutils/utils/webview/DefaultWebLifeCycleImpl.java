package com.yl.androidutils.utils.webview;

import android.os.Build;
import android.webkit.WebView;


public class DefaultWebLifeCycleImpl implements WebLifeCycle {
    private WebView mWebView;

    DefaultWebLifeCycleImpl(WebView webView) {
        this.mWebView = webView;
    }

    @Override
    public void onResume() {
        if (this.mWebView != null) {

            if (Build.VERSION.SDK_INT >= 11)
                this.mWebView.onResume();

            this.mWebView.resumeTimers();
        }


    }

    @Override
    public void onPause() {

        if (this.mWebView != null) {
            this.mWebView.pauseTimers();
            if (Build.VERSION.SDK_INT >= 11)
                this.mWebView.onPause();
        }
    }

    @Override
    public void onDestroy() {

        AgentWebUtils.clearWebView(this.mWebView);
    }
}
