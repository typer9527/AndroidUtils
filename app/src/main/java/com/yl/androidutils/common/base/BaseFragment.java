package com.yl.androidutils.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment 基类，封装一些常用的功能
 * 注意：使用的是v4包下的Fragment {@link Fragment}
 * Created by xuyougen on 2018/3/1.
 */

public abstract class BaseFragment extends Fragment {

    public Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 初始化控件，交给子类实现
     */
    protected abstract View initView();

    /**
     * 初始化数据，交给子类实现
     */
    protected abstract void initData();

}
