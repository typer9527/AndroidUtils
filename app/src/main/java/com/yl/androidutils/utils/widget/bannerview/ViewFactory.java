package com.yl.androidutils.utils.widget.bannerview;

/**
 * Created by gh on 2017/7/1.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.dawei.okmaster.R;
import com.dawei.okmaster.utils.GlideUtils;

/**
 * ImageView创建工厂（大图轮播）
 */
public class ViewFactory {

    /**
     * 获取ImageView视图的同时加载显示url
     */
    public static ImageView getImageView(Context context, String url) {
        ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.view_banner, null);
        GlideUtils.loadImage(context, url, imageView, R.color.color_light_gray);
        return imageView;
    }
}
