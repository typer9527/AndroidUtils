package com.yl.androidutils.utils.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 区实体类
 * Created by Yangli on 2018/3/14.
 */

public class AreaBean {
    @SerializedName("Name")
    public String name;
    @SerializedName("id")
    public int id;
    @SerializedName("state")
    public String state;
    @SerializedName("children")
    public List<String> children;

    public String getPickerViewText() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
