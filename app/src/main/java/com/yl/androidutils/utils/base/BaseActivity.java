package com.yl.androidutils.utils.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

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
 * Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initBasePresenter();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (isRegisterEventBus()) {
            EventBusUtils.register(this);
        }
        setStatusBar(getStatusBarBackground(), isLightMode());
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
        initCreate(savedInstanceState);
    }

    /**
     * 子类是否需要透明状态栏
     *
     * @return true 需要透明状态栏，反之不透明
     */
    protected abstract int getStatusBarBackground();

    protected abstract boolean isLightMode();

    /**
     * 设置透明状态栏
     */
    private void setStatusBar(int color, boolean isLightMode) {
        //大于5.0才设置
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //大于6.0 并且是亮色模式
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && isLightMode) {
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            }
            getWindow().setStatusBarColor(color);
        }
    }

    public void initCreate(Bundle savedInstanceState) {

    }

    public void initBasePresenter() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isRegisterEventBus()) {
            EventBusUtils.unregister(this);
        }
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void initView();

    public void initData() {

    }

    public void initListener() {

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
                mProgressDialog = ProgressDialog.show(this, "", "加载中...", true, false);
                return;
            }
            mProgressDialog = ProgressDialog.show(this, "", msg, true, false);
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

