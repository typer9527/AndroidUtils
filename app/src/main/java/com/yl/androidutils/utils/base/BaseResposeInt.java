package com.yl.androidutils.utils.base;

import com.dawei.okmaster.common.ErrCode;

/**
 * 项目名：  das-config-app
 * 包名：    com.dawei.okmaster.base
 * 文件名:   BaseResposeInt
 * 创建者:   dpc
 * 创建时间:  2018/1/22 11:31
 * 描述：    TODO
 */

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
