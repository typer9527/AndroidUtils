package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * 返利数据实体类
 * Created by Yangli on 2018/3/21.
 */

public class RebateBean {
    @SerializedName("ID")
    public int id;
    @SerializedName("Type")
    public int type;
    @SerializedName("Amount")
    public float amount;
    @SerializedName("CurrentBalance")
    public float currentAmount; // 返利明细使用
    @SerializedName("Description")
    public String des;
    @SerializedName("UpdateTime")
    public String time;
    @SerializedName("TradeCode")
    public String tradeCode;
    @SerializedName("TypeVal")
    public String typeVal;
}
