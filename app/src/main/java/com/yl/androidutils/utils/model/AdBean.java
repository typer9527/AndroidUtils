package com.yl.androidutils.utils.model;

import com.google.gson.annotations.SerializedName;

/**
 * 广告实体类，包括首页banner、首页图片
 * Created by Administrator on 2018/3/8.
 */

public class AdBean {
    @SerializedName("Name")
    public String title;
    @SerializedName("Pic")
    public String picUrl;
    @SerializedName("Url")
    public String adUrl;
    @SerializedName("UrlType")
    public int urlType; // 1 是跳转url  为2 根据指定的模块去跳转
    @SerializedName("SystemClass")
    public String className;
    @SerializedName("SystemClassVal")
    public int classVal;
    @SerializedName("Type")
    public String type;
}
