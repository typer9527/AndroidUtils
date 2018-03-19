package com.yl.androidutils.utils.model;

import com.google.gson.annotations.SerializedName;

/**
 * 用户协议实体类
 * Created by Administrator on 2018/3/12.
 */

public class ProtocolBean {
    @SerializedName("ID")
    public int id;
    @SerializedName("Title")
    public String title;
    @SerializedName("Contents")
    public String content;
}
