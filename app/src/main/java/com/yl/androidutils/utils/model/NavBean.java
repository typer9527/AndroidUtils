package com.yl.androidutils.utils.model;

import com.google.gson.annotations.SerializedName;

/**
 * 首页导航栏item实体类
 * Created by Administrator on 2018/3/9.
 */

public class NavBean {
    @SerializedName("Name")
    public String name;
    @SerializedName("Icon")
    public String iconUrl;
    @SerializedName("ID")
    public int id;
    @SerializedName("SystemClass")
    public String className; // SystemClass跳转的模块
    @SerializedName("SystemClassVal") // SystemClassVal跳转模块的id
    public int classVal;
    @SerializedName("Type")
    private int type; // Type为1是特定分类 2是返利的分类
}
