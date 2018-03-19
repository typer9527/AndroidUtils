package com.yl.androidutils.common.utils;

import android.content.Context;

import cc.ahxb.hlg.common.md5.AESOperator;

/**
 * 加解密工具类
 * Created by Yangli on 2018/3/13.
 */

public class SafeUtils {
    /**
     * 解密
     *
     * @param context 上下文
     * @param text    被加密文本
     * @return 解密文本
     */
    public static String decrypt(Context context, String text) {
        String iv = (String) SPUtils.get(context, "safe_iv", "");
        String key = (String) SPUtils.get(context, "safe_key", "");
        try {
            return AESOperator.getInstance().decrypt(text, iv, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     *
     * @param context 上下文
     * @param text    待加密文本
     * @return 加密文本
     */
    public static String encrypt(Context context, String text) {
        String iv = (String) SPUtils.get(context, "safe_iv", "");
        String key = (String) SPUtils.get(context, "safe_key", "");
        try {
            return AESOperator.getInstance().encrypt(text, iv, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
