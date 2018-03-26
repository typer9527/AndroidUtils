package com.yl.androidutils.common.base;

import com.yl.androidutils.common.common.ErrCode;

import java.io.Serializable;

/**
 * 服务器返回数据基类
 */
public class BaseRespose<T> implements Serializable {

    private static final long serialVersionUID = 2484868567614623456L;
    /**
     * {
     *   "Success": true,
     *   "ErrCode": {
     *       "Code": 0,
     *       "ErrMessage": null
     *   },
     *   "Data": {
     *    }
     */

    private boolean success;
    private ErrCode errCode;
    private T data;


    public BaseRespose() {
    }


    public BaseRespose(boolean success, ErrCode errCode, T data) {
        this.success = success;
        this.errCode = errCode;
        this.data = data;
    }


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


    public ErrCode getErrCode() {
        return errCode;
    }


    public void setErrCode(ErrCode errCode) {
        this.errCode = errCode;
    }


    public T getData() {
        return data;
    }


    public void setData(T data) {
        this.data = data;
    }
}
