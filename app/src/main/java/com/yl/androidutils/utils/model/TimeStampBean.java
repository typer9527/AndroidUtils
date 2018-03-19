package com.yl.androidutils.utils.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/5.
 */

public class TimeStampBean implements Serializable{

    /**
     * Time : 1513056361
     * Val : 31ff41cd2d72ae30203e266d729685
     * ID : 5
     */

    @SerializedName("Time")
    public int Time;
    @SerializedName("Val")
    public String Val;
    @SerializedName("ID")
    public String ID;
}