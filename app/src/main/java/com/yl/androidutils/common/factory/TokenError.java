package com.yl.androidutils.common.factory;//package com.gh.okmaster.factory;
//
//import android.app.Activity;
//import android.content.Context;
//import android.support.v7.app.AlertDialog;
//
//import com.gh.okmaster.interfaces.ErrorCode;
//
//
///**
// * Token错误
// */
//
//public class TokenError implements ErrorCode {
//
//    private AlertDialog alertDialog;
//
//    @Override
//    public void doSomething(final Context context, String errorTip) {
//        if (context != null) {
//            if (alertDialog != null) {
//                if (alertDialog.isShowing()) {
//                    return;
//                }
//            } else {
//                alertDialog = new AlertDialog.Builder(context)
//                        .setMessage("登录过期，请重新登录")
//                        .setPositiveButton("确定", (dialogInterface, i) -> {
//                            ((Activity) context).finish();
//                        }).setNegativeButton("取消", (dialogInterface, i) -> {
//                            ((Activity) context).finish();
//
//                        })
//                        .create();
//
//                alertDialog.setCancelable(false);
//                alertDialog.show();
//            }
//
//        }
//    }
//}
