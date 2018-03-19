package com.yl.androidutils.utils.model;

import com.google.gson.annotations.SerializedName;

/**
 * 积分订单实体类
 * Created by Yangli on 2018/3/15.
 */

public class OrderBean {
    @SerializedName("ID")
    public int id;
    @SerializedName("Name")
    public String name; // 订单详情使用
    @SerializedName("Title")
    public String title; // // 订单列表使用
    @SerializedName("Remark")
    public String remark; // 备注 订单详情使用
    @SerializedName("OrderNo")
    public String orderNo;
    @SerializedName("ProID")
    public int productId;
    @SerializedName("Num")
    public int num;
    @SerializedName("Price")
    public float price; // 付款
    @SerializedName("Total")
    public int integral; // 积分
    @SerializedName("Address")
    public String address;
    @SerializedName("MainPic")
    public String picUrl;
    @SerializedName("TranceState")
    public int state; // 订单状态 0待发货  1已发货 2已签收
    @SerializedName("TranceStateVal")
    public String stateVal;
    @SerializedName("CreateTime")
    public String time;
    @SerializedName("Logistics")
    public int logistics; // 是否有物流 1是0否

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", productId=" + productId +
                ", num=" + num +
                ", price=" + price +
                ", integral=" + integral +
                ", address='" + address + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", state=" + state +
                ", stateVal='" + stateVal + '\'' +
                ", time='" + time + '\'' +
                ", logistics=" + logistics +
                '}';
    }
}
