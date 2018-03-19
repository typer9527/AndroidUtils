package com.yl.androidutils.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import cc.ahxb.hlg.common.utils.SPUtils;

/**
 * 禁止左右滑动的 ViewPager
 * Created by Administrator on 2018/2/28.
 */

public class NoScrollViewPager extends ViewPager {

    private CheckLoginListener listener;

    public void setCheckLoginListener(CheckLoginListener listener) {
        this.listener = listener;
    }

    public NoScrollViewPager(Context context) {
        this(context, null);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentItem(int item) {
        boolean isLogin = (boolean) SPUtils.get(getContext(), "is_login", false);
        if ((item == 4 || item == 2) && !isLogin)
            listener.jumpToLogin();
        else
            super.setCurrentItem(item);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        boolean isLogin = (boolean) SPUtils.get(getContext(), "is_login", false);
        if ((item == 4 || item == 2) && !isLogin)
            listener.jumpToLogin();
        else
            super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //不拦截事件
        return false;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //不消费事件
        return false;
    }


    public interface CheckLoginListener {
        void jumpToLogin();
    }
}
