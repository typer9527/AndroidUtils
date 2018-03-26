package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Yangli on 2018/3/21.
 */

public class ExpressBean {
    @SerializedName("ID")
    public int id;
    @SerializedName("ExpressName")
    public String expressName;
    @SerializedName("ExpressTel")
    public String expressTel;
    @SerializedName("ExpressPic")
    public String expressPic;
    @SerializedName("TranceNo")
    public String expressNo;
    @SerializedName("ExpressAll")
    public List<ExpressInfo> infoList;

    public class ExpressInfo {
        public String time;
        @SerializedName("context")
        public String state;
        public String location;
    }
}
