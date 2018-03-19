package com.yl.androidutils.utils.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/5.
 */

public class HttpRespond<T> implements Serializable {


    /**
     * result : 1
     * message : 恭喜您，登录成功！
     * data :
     */

    @SerializedName("result")
    public int result;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public T data;
}
