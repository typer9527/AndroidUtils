package com.yl.androidutils.common.common;

/**
 * 项目名：  das-config-app
 * 包名：    com.dawei.okmaster.common
 * 文件名:   ErrCode
 * 创建者:   dpc
 * 创建时间:  2018/1/22 10:13
 * 描述：    TODO
 */

public class ErrCode {
    private  int code;
    private String errMessage;


    public ErrCode() {
    }


    public ErrCode(int code, String errMessage) {
        this.code = code;
        this.errMessage = errMessage;
    }


    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }


    public String getErrMessage() {
        return errMessage;
    }


    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}
