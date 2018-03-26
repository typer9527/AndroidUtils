package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 首页三张广告图
 * Created by Administrator on 2018/3/10.
 */

public class PicAdsBean {
    @SerializedName("left")
    public List<AdBean> oneLeft;
    @SerializedName("right")
    public List<AdBean> twoRight;
}
