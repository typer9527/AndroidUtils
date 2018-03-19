package com.yl.androidutils.utils.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 省实体类
 * Created by Yangli on 2018/3/14.
 */

public class ProvinceBean {
    @SerializedName("Name")
    public String name;
    @SerializedName("id")
    public int id;
    @SerializedName("state")
    public String state;
    @SerializedName("children")
    public List<CityBean> cityBeans;

    public String getPickerViewText() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
