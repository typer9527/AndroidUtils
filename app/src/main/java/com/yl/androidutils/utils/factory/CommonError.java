package com.yl.androidutils.utils.factory;//package com.gh.okmaster.factory;
//
//import android.content.Context;
//import android.text.TextUtils;
//
//import com.gh.okmaster.interfaces.ErrorCode;
//import com.gh.okmaster.utils.ToastUtils;
//
//
///**
// * 普通错误,直接提示
// */
//
//public class CommonError implements ErrorCode {
//
//    @Override
//    public void doSomething(Context context, String errorTip) {
//        if (!TextUtils.isEmpty(errorTip)) {
//            ToastUtils.showShort(context, errorTip);
//        }
//    }
//}
