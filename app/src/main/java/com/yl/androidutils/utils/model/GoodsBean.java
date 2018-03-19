package com.yl.androidutils.utils.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 商品实体类
 * Created by Administrator on 2018/3/8.
 */

public class GoodsBean implements Serializable {
    @SerializedName("ID")
    public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("zk_final_price")
    public float finalPrice; // 券后价格
    @SerializedName("Youhui")
    public float discount; // 优惠价格
    @SerializedName("pict_url")
    public String imgUrl; // 商品图片链接
}
