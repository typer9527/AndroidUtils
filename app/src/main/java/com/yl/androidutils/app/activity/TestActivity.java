package com.yl.androidutils.app.activity;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yl.androidutils.R;
import com.yl.androidutils.app.model.CaptChaBean;
import com.yl.androidutils.app.presenter.TestPresenter;
import com.yl.androidutils.app.view.TestView;
import com.yl.androidutils.common.base.BaseMvpActivity;
import com.yl.androidutils.common.common.HttpRespond;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class TestActivity extends BaseMvpActivity<TestView, TestPresenter> implements TestView {
    @BindView(R.id.iv_captcha)
    ImageView ivCaptcha;

    @Override
    protected int getStatusBarBackground() {
        return getResources().getColor(R.color.colorPrimaryDark);
    }

    @Override
    protected boolean isLightMode() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        mPresenter.getCaptcha();
    }

    @OnClick(R.id.iv_captcha)
    public void onCaptchaClick() {
        mPresenter.getCaptcha();
    }

    @Override
    public TestPresenter initPresenter() {
        return new TestPresenter();
    }

    @Override
    public void showCaptchaPic(HttpRespond<CaptChaBean> respond) {
        Glide.with(this).load(respond.data.captchaUrl + "?a="
                + new Random().nextInt()).into(ivCaptcha);
    }
}
