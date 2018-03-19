package com.yl.androidutils.common.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.dawei.okmaster.model.AdBean;
import com.dawei.okmaster.model.NavBean;
import com.dawei.okmaster.utils.ToastUtils;

import cc.ahxb.hlg.hlgyhq.activity.HtmlActivity;
import cc.ahxb.hlg.hlgyhq.activity.ScreeningResultActivity;

/**
 * 广告等的跳转处理工具栏
 * Created by Yangli on 2018/3/15.
 */

public class AdHandlerUtils {
    public static void handleAdBean(AdBean bean, Context context) {
        if (bean.urlType == 1) { // 跳转指定url
            if (bean.adUrl == null) {
                ToastUtils.showShort(context, "跳转Url无效");
            } else {
                Intent intent = new Intent(context, HtmlActivity.class);
                intent.putExtra("extra_url", bean.adUrl);
                context.startActivity(intent);
            }
        } else if (bean.urlType == 2) { // 跳转特定模块，同handleNavBean
            NavBean navBean = new NavBean();
            navBean.classVal = bean.classVal;
            navBean.className = bean.className;
            navBean.name = bean.title;
            navBean.id = 0; // 无用字段
            navBean.iconUrl = ""; // 无用字段
            handleNavBean(navBean, context);
        }
    }

    public static void handleNavBean(NavBean bean, Context context) {
        if (bean.classVal == 0) {
            ToastUtils.showShort(context, "跳转Url无效");
        }
        if ("goods".equals(bean.className)) {
            // 跳转商品，商品的栏目，据SystemClassVal这个字段返回
            Intent intent = new Intent(context, ScreeningResultActivity.class);
            intent.putExtra("extra_title", bean.name);
            Bundle bundle = new Bundle();
            bundle.putString("keyword", "");
            bundle.putString("low", "");
            bundle.putString("high", "");
            bundle.putInt("other", 0);
            bundle.putString("classid", Integer.toString(bean.classVal));
            bundle.putInt("order", 0);
            intent.putExtra("data", bundle);
            context.startActivity(intent);
        } else if ("other".equals(bean.className)) {
            // other 是内置模块 （1是优惠券 2是9.9包邮）
            Intent intent = new Intent(context, ScreeningResultActivity.class);
            intent.putExtra("extra_title", bean.name);
            Bundle bundle = new Bundle();
            bundle.putString("keyword", "");
            bundle.putString("low", "");
            bundle.putString("high", "");
            bundle.putInt("other", 0);
            bundle.putString("classid", "");
            bundle.putInt("order", bean.classVal);
            intent.putExtra("data", bundle);
            context.startActivity(intent);
        } else if ("article".equals(bean.className)) {
            // article为文章（SystemClassVal这个字段返回  1是关于我们  2 注册协议  3是版本介绍）
            jumpToArticle(bean, context);
        } else if ("user".equals(bean.className)) {
            // 会员中心相关的页面（1是我的订单 2是我的推广 3是积分 4是返现）
        }
    }

    private static void jumpToArticle(NavBean bean, Context context) {
        Intent intent = new Intent(context, HtmlActivity.class);
        intent.putExtra("id", bean.classVal);
        context.startActivity(intent);
    }

    private static void jumpToUser(NavBean bean, Context context) {
        switch (bean.classVal) {
            case 0:
                break;
            case 1:
                break;
            default:
        }
    }
}
