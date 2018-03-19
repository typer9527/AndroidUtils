package com.yl.androidutils.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dawei.okmaster.R;
import com.dawei.okmaster.utils.ViewAnimationUtils;

/**
 * 加载状态的自定义View
 */

public class StateLinearLayout extends LinearLayout {

    //当前的加载状态
    private int mCurrentState;
    private static final int STATE_SUCCESS = 0;
    private static final int STATE_LOADING = 1;
    private static final int STATE_ERROR = 2;
    private static final int STATE_NO_NETWORK = 3;
    private static final int STATE_EMPTY = 4;
    //布局添加位置
    private static final int VIEW_POSITION = 0;

    private int mLoadingViewId;
    private int mErrorViewId;
    private int mNoNetworkViewId;
    private int mEmptyViewId;

    private View mLoadingView;
    private View mErrorView;
    private View mNoNetworkView;
    private View mEmptyView;

    private LayoutInflater mInflater;
    private ViewGroup.LayoutParams params;

    private onErrorRefreshListener mRefreshListener;

    public StateLinearLayout(@NonNull Context context) {
        this(context, null);
    }

    public StateLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.styleStateView);
    }

    public StateLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StateView,
                defStyleAttr, R.style.StateView_style);

        mLoadingViewId = typedArray.getResourceId(R.styleable.StateView_loadingView, R.layout
                .view_loading);

        mErrorViewId = typedArray.getResourceId(R.styleable.StateView_errorView, R.layout
                .view_server_error);

        mNoNetworkViewId = typedArray.getResourceId(R.styleable.StateView_noNetworkView, R.layout
                .view_no_network);

        mEmptyViewId = typedArray.getResourceId(R.styleable.StateView_emptyView, R.layout.view_empty);
        typedArray.recycle();
        mInflater = LayoutInflater.from(context);
        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams
                .MATCH_PARENT);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        showSuccess();
    }

    /**
     * 加载成功，隐藏加载状态的View
     */
    public void showSuccess() {
        mCurrentState = STATE_SUCCESS;
        showViewByState(mCurrentState);
    }

    /**
     * 显示加载中的状态
     */
    public void showLoading() {
        mCurrentState = STATE_LOADING;
        if (null == mLoadingView) {
            mLoadingView = mInflater.inflate(mLoadingViewId, null);
            addView(mLoadingView, VIEW_POSITION, params);
        }
        showViewByState(mCurrentState);
    }

    /**
     * 显示加载失败(服务器出错)
     */
    public void showError() {
        mCurrentState = STATE_ERROR;
        if (null == mErrorView) {
            mErrorView = mInflater.inflate(mErrorViewId, null);
            mErrorView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (null != mRefreshListener) {
                        mRefreshListener.onErrorRefresh();
                    }
                }
            });
            addView(mErrorView, VIEW_POSITION, params);
        }
        showViewByState(mCurrentState);
    }

    /**
     * 显示没有网络状态
     */
    public void showNoNetwork() {
        mCurrentState = STATE_NO_NETWORK;
        if (null == mNoNetworkView) {
            mNoNetworkView = mInflater.inflate(mNoNetworkViewId, null);
            mNoNetworkView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (null != mRefreshListener) {
                        mRefreshListener.onErrorRefresh();
                    }
                }
            });
            addView(mNoNetworkView, VIEW_POSITION, params);
        }
        showViewByState(mCurrentState);
    }

    /**
     * 显示无数据状态
     */
    public void showEmpty() {
        mCurrentState = STATE_EMPTY;
        if (null == mEmptyView) {
            mEmptyView = mInflater.inflate(mEmptyViewId, null);
            mEmptyView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (null != mRefreshListener) {
                        mRefreshListener.onErrorRefresh();
                    }
                }
            });
            addView(mEmptyView, VIEW_POSITION, params);
        }
        showViewByState(mCurrentState);
    }

    private void showViewByState(int state) {
        //如果当前状态为加载成功
//        this.setVisibility(state == STATE_SUCCESS ? View.VISIBLE : View.VISIBLE);
        setVisibility(VISIBLE);
        if (null != mLoadingView) {
            if (state == STATE_LOADING) {
                mLoadingView.setVisibility(VISIBLE);
            } else {
                ViewAnimationUtils.goneViewByAlpha(mLoadingView);
            }
        }

        if (null != mErrorView) {
            if (state == STATE_ERROR) {
                ViewAnimationUtils.visibleViewByAlpha(mErrorView);
            } else {
                ViewAnimationUtils.goneViewByAlpha(mErrorView);
            }
        }

        if (null != mNoNetworkView) {
            if (state == STATE_NO_NETWORK) {
                ViewAnimationUtils.visibleViewByAlpha(mNoNetworkView);
            } else {
                ViewAnimationUtils.goneViewByAlpha(mNoNetworkView);
            }
        }

        if (null != mEmptyView) {
            if (state == STATE_EMPTY) {
                ViewAnimationUtils.visibleViewByAlpha(mEmptyView);
            } else {
                ViewAnimationUtils.goneViewByAlpha(mEmptyView);
            }
        }
    }


    public void setonErrorRefreshListener(onErrorRefreshListener listener) {
        mRefreshListener = listener;
    }




    /**
     * 刷新接口
     */
    public interface onErrorRefreshListener {
        void onErrorRefresh();
    }
}
