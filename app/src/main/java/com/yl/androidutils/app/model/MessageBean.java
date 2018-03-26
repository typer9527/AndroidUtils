package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Yangli on 2018/3/20.
 */

public class MessageBean {
    // @SerializedName("ID")
    public int id;
    public String name;
    public String pic; // 消息类型列表使用
    @SerializedName("SendMess")
    public String message;
    @SerializedName("SendTime")
    public String time;
    public int status;
}
