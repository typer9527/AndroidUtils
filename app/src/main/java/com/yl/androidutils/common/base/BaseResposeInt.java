package com.yl.androidutils.common.base;

import com.yl.androidutils.common.common.ErrCode;

public class BaseResposeInt {
    private boolean success;
    private ErrCode errCode;
    private int data;


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


    public int getData() {
        return data;
    }


    public void setData(int data) {
        this.data = data;
    }
}
