package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * 提现信息实体类
 * Created by Yangli on 2018/3/21.
 */

public class WithdrawBean {
    @SerializedName("ID")
    public int id;
    @SerializedName("PayName")
    public String payName;
    @SerializedName("PayNum")
    public String payNo;
    @SerializedName("FeeWithdraw")
    public float withdrawCost;
    @SerializedName("LowestWithdraw")
    public float lowestCash;
    @SerializedName("HighestWithdraw")
    public float highestCash;
    @SerializedName("BalanceYe")
    public String withdrawCash;
}
