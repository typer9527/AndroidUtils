package com.yl.androidutils.utils.imageloader.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.dawei.okmaster.imageloader.glide.progress.OnGlideImageViewListener;
import com.dawei.okmaster.imageloader.glide.progress.OnProgressListener;
import com.dawei.okmaster.imageloader.glide.progress.ProgressManager;

import java.lang.ref.WeakReference;

public class GlideImageLoader {

    private static final String ANDROID_RESOURCE = "android.resource://";
    private static final String FILE = "file://";
    private static final String SEPARATOR = "/";
    private static final String HTTP = "http";
    private static final String HTTPS = "https";


    private WeakReference<ImageView> mImageView;
    private Object mImageUrlObj;
    private long mTotalBytes = 0;
    private long mLastBytesRead = 0;
    private boolean mLastStatus = false;
    private Handler mMainThreadHandler;

    private OnProgressListener internalProgressListener;
    private OnGlideImageViewListener onGlideImageViewListener;
    private OnProgressListener onProgressListener;

    public GlideImageLoader(ImageView iv) {
        mImageView = new WeakReference<>(iv);
        mMainThreadHandler = new Handler(Looper.getMainLooper());
    }

    public ImageView getImageView() {
        if (mImageView != null) {
            return mImageView.get();
        }
        return null;
    }

    public Context getContext() {
        if (getImageView() != null) {
            return getImageView().getContext();
        }
        return null;
    }

    public String getImageUrl() {
        if (mImageUrlObj == null) return null;
        if (!(mImageUrlObj instanceof String)) return null;
        return (String) mImageUrlObj;
    }

    public Uri resId2Uri(int resourceId) {
        if (getContext() == null) {
            return null;
        }
        return Uri.parse(ANDROID_RESOURCE + getContext().getPackageName() + SEPARATOR + resourceId);
    }

    public void load(int resId, RequestOptions options) {
        load(resId2Uri(resId), options);
    }

    public void load(Uri uri, RequestOptions options) {
        if (uri == null || getContext() == null) {
            return;
        }
        requestBuilder(uri, options).into(getImageView());
    }

    public void load(String url, RequestOptions options) {
        if (url == null || getContext() == null) {
            return;
        }
        requestBuilder(url, options).into(getImageView());
    }

    public RequestBuilder<Drawable> requestBuilder(Object obj, RequestOptions options) {
        this.mImageUrlObj = obj;
        return Glide.with(getContext())
                .load(obj)
                .transition(new DrawableTransitionOptions().crossFade(200))
                .apply(options)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable>
                            target, boolean isFirstResource) {
                        mainThreadCallback(mLastBytesRead, mTotalBytes, true, e);
                        ProgressManager.removeProgressListener(internalProgressListener);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable>
                            target, DataSource dataSource, boolean isFirstResource) {
                        mainThreadCallback(mLastBytesRead, mTotalBytes, true, null);
                        ProgressManager.removeProgressListener(internalProgressListener);
                        return false;
                    }
                });
    }

    public RequestOptions requestOptions(int placeholderResId) {
        return requestOptions(placeholderResId, placeholderResId);
    }

    public RequestOptions requestOptions(int placeholderResId, int errorResId) {
        return new RequestOptions()
                .centerCrop()
                .placeholder(placeholderResId)
                .error(errorResId);
    }


    /**
     * 圆形的RequestOptions
     *
     * @param placeholderResId
     * @return
     */
    public RequestOptions circleRequestOptions(int placeholderResId) {
        return circleRequestOptions(placeholderResId, placeholderResId);
    }

    /**
     * 圆形的RequestOptions
     *
     * @param placeholderResId
     * @param errorResId
     * @return
     */
    public RequestOptions circleRequestOptions(int placeholderResId, int errorResId) {
        return requestOptions(placeholderResId, errorResId).transform(new GlideCircleTransformation());
    }

    /**
     * 加载图片-网络
     *
     * @param url
     * @param placeholderResId
     */
    public void loadImage(String url, int placeholderResId) {
        load(url, requestOptions(placeholderResId));
    }

    /**
     * 加载本地图片-DrawableRes
     *
     * @param resId
     * @param placeholderResId
     */
    public void loadLocalImage(@DrawableRes int resId, int placeholderResId) {
        load(resId, requestOptions(placeholderResId));
    }

    /**
     * 加载本地图片-绝对路径
     *
     * @param localPath
     * @param placeholderResId
     */
    public void loadLocalImage(String localPath, int placeholderResId) {
        load(FILE + localPath, requestOptions(placeholderResId));
    }

    /**
     * 加载圆形网络图片
     *
     * @param url
     * @param placeholderResId
     */
    public void loadCircleImage(String url, int placeholderResId) {
        load(url, circleRequestOptions(placeholderResId));
    }

    /**
     * 加载圆形本地图片-DrawableRes
     *
     * @param resId
     * @param placeholderResId
     */
    public void loadLocalCircleImage(@DrawableRes int resId, int placeholderResId) {
        load(resId, circleRequestOptions(placeholderResId));
    }

    /**
     * 加载圆形本地图片-本地路径
     *
     * @param localPath
     * @param placeholderResId
     */
    public void loadLocalCircleImage(String localPath, int placeholderResId) {
        load(FILE + localPath, circleRequestOptions(placeholderResId));
    }

    /**
     * 获取加载进度
     */
    private void addProgressListener() {
        if (getImageUrl() == null) return;
        final String url = getImageUrl();

        if (url.startsWith(HTTP) || url.startsWith(HTTPS)) {
            internalProgressListener = new OnProgressListener() {
                @Override
                public void onProgress(String imageUrl, long bytesRead, long totalBytes, boolean isDone,
                                       GlideException exception) {
                    if (totalBytes == 0) return;
                    if (!url.equals(imageUrl)) return;
                    if (mLastBytesRead == bytesRead && mLastStatus == isDone) return;

                    mLastBytesRead = bytesRead;
                    mTotalBytes = totalBytes;
                    mLastStatus = isDone;
                    mainThreadCallback(bytesRead, totalBytes, isDone, exception);

                    if (isDone) {
                        ProgressManager.removeProgressListener(this);
                    }
                }
            };
            ProgressManager.addProgressListener(internalProgressListener);
        }
    }

    private void mainThreadCallback(final long bytesRead, final long totalBytes, final boolean isDone,
                                    final GlideException exception) {
        mMainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                final int percent = (int) ((bytesRead * 1.0f / totalBytes) * 100.0f);

                if (onProgressListener != null) {
                    onProgressListener.onProgress((String) mImageUrlObj, bytesRead, totalBytes, isDone,
                            exception);
                }

                if (onGlideImageViewListener != null) {
                    onGlideImageViewListener.onProgress(percent, isDone, exception);
                }
            }
        });
    }

    public void setOnGlideImageViewListener(String imageUrl, OnGlideImageViewListener
            onGlideImageViewListener) {
        this.mImageUrlObj = imageUrl;
        this.onGlideImageViewListener = onGlideImageViewListener;
        addProgressListener();
    }

    public void setOnProgressListener(String imageUrl, OnProgressListener onProgressListener) {
        this.mImageUrlObj = imageUrl;
        this.onProgressListener = onProgressListener;
        addProgressListener();
    }
}