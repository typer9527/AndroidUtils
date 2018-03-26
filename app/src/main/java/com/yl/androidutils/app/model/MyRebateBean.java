package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 我的返利实体类
 * Created by Yangli on 2018/3/21.
 */

public class MyRebateBean {
    @SerializedName("points")
    public List<RebateBean> rebateBeans;
    @SerializedName("curpoint")
    public float currentMoney;
    @SerializedName("arrivepoint")
    public float notArrivedMoney;
}
