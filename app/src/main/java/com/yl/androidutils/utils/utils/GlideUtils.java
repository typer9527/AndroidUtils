package com.yl.androidutils.utils.utils;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.dawei.okmaster.R;
import com.dawei.okmaster.utils.transform.GlideRadianTransform;
import com.dawei.okmaster.utils.transform.GlideRoundTransform;

/**
 * Glide4.0加载图片工具类
 */

public class GlideUtils {

    /**
     * Don't let anyone instantiate this class.
     */
    private GlideUtils() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 加载普通的图片
     *
     * @param context
     * @param strUrl
     * @param imageView
     * @param id
     */
    public static void loadImage(Context context, final String strUrl, final ImageView imageView,
                                 @DrawableRes final int id) {
        Glide.with(context)
                .load(strUrl)
                .apply(new RequestOptions()
                        .centerCrop()
                        .error(id)
                        .placeholder(id)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .transition(new DrawableTransitionOptions().crossFade(400)) //使用变换效果
                .into(imageView);
    }

    public static void loadImageFitCenter(Context context, final String strUrl, final ImageView imageView,
                                 @DrawableRes final int id) {
        Glide.with(context)
                .load(strUrl)
                .apply(new RequestOptions()
                        .fitCenter()
                        .error(id)
                        .placeholder(id)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .transition(new DrawableTransitionOptions().crossFade(400)) //使用变换效果
                .into(imageView);
    }

    /**
     * 加载有弧度的
     *
     * @param context
     * @param strUrl
     * @param imageView
     * @param radian
     * @param id
     */
    public static void loadRadianImage(Context context, final String strUrl, final ImageView imageView,
                                       float radian, @DrawableRes final int id) {
        Glide.with(context)
                .load(strUrl)
                .apply(new RequestOptions()
                        .centerCrop()
                        .transform(new GlideRadianTransform(radian))
                        .error(id)
                        .placeholder(id)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .transition(new DrawableTransitionOptions().crossFade(300)) //使用变换效果
                .into(imageView);
    }

    /**
     * 加载圆形的ImageView
     *
     * @param context
     * @param strUrl
     * @param imageView
     * @param id
     */
    public static void loadRoundImage(Context context, final String strUrl, final ImageView imageView,
                                      @DrawableRes final int id) {
        Glide.with(context)
                .load(strUrl)
                .apply(new RequestOptions()
                        .centerCrop()
                        .transform(new GlideRoundTransform())
                        .error(id)
                        .placeholder(id)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .transition(new DrawableTransitionOptions().crossFade(300)) //使用变换效果
                .into(imageView);
    }

    //加载drawable图片
    public static void loadResImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
            .load(resourceIdToUri(context, resId))
            .apply(new RequestOptions()
                .centerCrop()
                .error(R.color.font_black_6)
                .placeholder(R.color.font_black_6)
                .diskCacheStrategy(DiskCacheStrategy.ALL))
            .transition(new DrawableTransitionOptions().crossFade(300)) //使用变换效果
            .into(imageView);
    }

    // 将资源ID转为Uri
    public static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";
}

