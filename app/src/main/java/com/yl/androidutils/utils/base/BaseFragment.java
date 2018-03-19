package com.yl.androidutils.utils.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.baichuan.android.trade.AlibcTrade;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AlibcShowParams;
import com.alibaba.baichuan.android.trade.model.OpenType;
import com.alibaba.baichuan.android.trade.page.AlibcBasePage;
import com.alibaba.baichuan.android.trade.page.AlibcDetailPage;
import com.alibaba.baichuan.android.trade.page.AlibcPage;
import com.alibaba.baichuan.trade.biz.context.AlibcTradeResult;
import com.dawei.okmaster.model.ProduceBean;
import com.dawei.okmaster.utils.EventBusUtils;
import com.dawei.okmaster.utils.StringUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;


/**
 * Fragment基类
 */
public abstract class BaseFragment extends Fragment {
    protected ProgressDialog mProgressDialog;

    /**
     * 贴附的activity
     */
    protected FragmentActivity mActivity;
    /**
     * 根view
     */
    protected View mRootView;
    /**
     * 是否对用户可见
     */
    protected boolean mIsVisible = false;
    /**
     * 是否加载完成
     * 当执行完oncreatview,View的初始化方法后方法后即为true
     */
    protected boolean mIsPrepare = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, mRootView);
            if (isRegisterEventBus()) {
                EventBusUtils.register(this);
            }
            mIsPrepare = true;
            initView(getArguments());
            initData();
            initListener();
        }
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isRegisterEventBus()) {
            EventBusUtils.unregister(this);
        }
    }

    /**
     * 设置根布局资源id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化View
     *
     * @param arguments 接收到的从其他地方传递过来的参数
     */
    protected abstract void initView(Bundle arguments);

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 设置监听事件
     */
    protected void initListener() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.mIsVisible = isVisibleToUser;
        if (isVisibleToUser) {
            onVisibleToUser();
        }
    }


    /**
     * 用户可见时执行的操作
     */
    protected void onVisibleToUser() {
        if (mIsPrepare && mIsVisible) {
            onLazyLoad();
        }
    }

    /**
     * 懒加载，仅当用户可见切view初始化结束后才会执行
     */
    protected void onLazyLoad() {

    }

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusCome(BaseEvent event) {
        if (event != null) {
            receiveEvent(event);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusCome(BaseEvent event) {
        if (event != null) {
            receiveStickyEvent(event);
        }
    }

    /**
     * 接收到分发到事件
     *
     * @param event 事件
     */
    protected void receiveEvent(BaseEvent event) {

    }

    /**
     * 接受到分发的粘性事件
     *
     * @param event 粘性事件
     */
    protected void receiveStickyEvent(BaseEvent event) {

    }


    public void showProgressDialog(String msg) {

        if (mProgressDialog == null) {
            if (StringUtils.isEmpty(msg)) {
                mProgressDialog = ProgressDialog.show(mActivity, "", "加载中...", true, false);
            } else {
                mProgressDialog = ProgressDialog.show(mActivity, "", msg, true, false);
            }

        } else {
            mProgressDialog.show();
        }
    }

    public void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }


    /**
     * 根据link跳转到淘宝
     */
    public void jumpToTaobaoWithModel(Activity activity, ProduceBean produceBean) {

        save(produceBean.getID() + "");
        String linkStr = null;
        if (!TextUtils.isEmpty(produceBean.getCoupon_click_url())) {
            //跳转到优惠券
            linkStr = produceBean.getCoupon_click_url();
        } else {
            //跳转到详情
            linkStr = produceBean.getClick_url();
        }

        AlibcPage page = new AlibcPage(linkStr);
        AlibcBasePage alibcBasePage = new AlibcDetailPage(produceBean.getNum_iid());
        AlibcShowParams showParams = new AlibcShowParams();
        showParams.setOpenType(OpenType.H5);
        AlibcTrade.show(activity, alibcBasePage, showParams, null, null, new AlibcTradeCallback() {
            @Override
            public void onTradeSuccess(AlibcTradeResult tradeResult) {
                String order_no = tradeResult.payResult.paySuccessOrders.toString().substring(1, tradeResult.payResult.paySuccessOrders.toString().length() - 1);
                order_creat(order_no);
            }

            @Override
            public void onFailure(int i, String s) {
                Log.e("onFailure", "电商SDK出错,错误码=" + i + " / 错误消息=" + s);
                // Toast.makeText(getContext(), "电商SDK出错,错误码="+i+" / 错误消息="+s, Toast.LENGTH_LONG).show();
            }
        });
    }


    /**
     * 根据link跳转到淘宝
     */
    public void jumpToTaobaoYouHuiQuan(Activity activity, ProduceBean produceBean) {

        save(produceBean.getID() + "");
        String linkStr = null;
        if (!TextUtils.isEmpty(produceBean.getCoupon_click_url())) {
            //跳转到优惠券
            linkStr = produceBean.getCoupon_click_url();
        } else {
            //跳转到详情
            linkStr = produceBean.getClick_url();
        }

        AlibcPage page = new AlibcPage(linkStr);
        AlibcBasePage alibcBasePage = new AlibcDetailPage(produceBean.getNum_iid());
        AlibcShowParams showParams = new AlibcShowParams();
        showParams.setOpenType(OpenType.H5);
        AlibcTrade.show(activity, page, showParams, null, null, new AlibcTradeCallback() {
            @Override
            public void onTradeSuccess(AlibcTradeResult tradeResult) {
                String order_no = tradeResult.payResult.paySuccessOrders.toString().substring(1, tradeResult.payResult.paySuccessOrders.toString().length() - 1);
                order_creat(order_no);
            }

            @Override
            public void onFailure(int i, String s) {
                Log.e("onFailure", "电商SDK出错,错误码=" + i + " / 错误消息=" + s);
                // Toast.makeText(getContext(), "电商SDK出错,错误码="+i+" / 错误消息="+s, Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 向服务器进行保存操作
     *
     * @param id
     */
    void save(String id) {

    }

    /**
     * 下单成功向服务器创建订单
     *
     * @param order_no
     */
    void order_creat(String order_no) {

    }


}
