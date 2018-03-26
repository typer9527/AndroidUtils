package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * 淘宝订单实体类
 * Created by Yangli on 2018/3/20.
 */

public class TbOrderBean {
    @SerializedName("ID")
    public int id;
    @SerializedName("Ordernumber")
    public String orderNo;
    @SerializedName("Productinformation")
    public String productName;
    @SerializedName("ProductID")
    public String productId;
    @SerializedName("Numbergoods")
    public int num;
    @SerializedName("Commodityprice")
    public float price;
    @SerializedName("OrderStatus")
    public String stateText;
    @SerializedName("Paymentamount")
    public float payment;
    @SerializedName("pict_url")
    public String picUrl;
    @SerializedName("Belongshop")
    public String shopName;
    @SerializedName("UserIntegral")
    public float userIntegral;
    @SerializedName("title")
    public String title;
    @SerializedName("click_url")
    public String clickUrl;
    @SerializedName("StatusVal")
    public String state;
    @SerializedName("Createtime")
    public String time;
}
