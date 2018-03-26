package com.yl.androidutils.common.factory;//package com.gh.okmaster.factory;
//
//import android.content.Context;
//
//import com.gh.okmaster.common.Constants;
//import com.gh.okmaster.interfaces.ErrorCode;
//
//
///**
// * 错误工厂
// */
//public class ErrorFactory {
//    public static void Error(Context context, int errorCode, String errotTip) {
//        ErrorCode errorCodeInterface = Constants.sparseArray.get(errorCode);
//        if (errorCodeInterface != null) {
//            errorCodeInterface.doSomething(context, errotTip);
//        }
//    }
//}
