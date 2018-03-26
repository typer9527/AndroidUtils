package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 首页底部商品分类和对应商品列表
 * Created by Administrator on 2018/3/10.
 */

public class GoodsClassBean {
    @SerializedName("Name")
    public String name;
    @SerializedName("Icon")
    public String normalIcUrl;
    @SerializedName("curricon")
    public String selectedIcUrl;
    @SerializedName("ID")
    public int id;
    @SerializedName("info")
    public List<ProduceBean> produceList;
}
