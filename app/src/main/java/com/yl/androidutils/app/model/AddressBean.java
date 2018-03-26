package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Yangli on 2018/3/14.
 */

public class AddressBean implements Serializable{
    @SerializedName("ID")
    public int id;
    @SerializedName("FullName")
    public String name;
    @SerializedName("Mobile")
    public String phoneNum;
    @SerializedName("ProID")
    public int provinceId;
    @SerializedName("CityID")
    public int cityId;
    @SerializedName("DisID")
    public int areaId;
    @SerializedName("Address")
    public String addressText;
    @SerializedName("IsDefault")
    public int isDefault;
    @SerializedName("PostCode")
    public String zipCode;
    @SerializedName("UpdateTime")
    public String updateTime;

    @Override
    public String toString() {
        return "AddressBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", addressText='" + addressText + '\'' +
                ", isDefault=" + isDefault +
                ", zipCode='" + zipCode + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
