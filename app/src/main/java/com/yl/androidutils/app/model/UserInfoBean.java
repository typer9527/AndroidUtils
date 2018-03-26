package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/3/12.
 */

public class UserInfoBean {
    @SerializedName("ID")
    public int id;
    @SerializedName("UserName")
    public String userName;
    @SerializedName("HeadImgVal")
    public String headImgUrl;
    @SerializedName("HeadImg")
    public String headImg;
    @SerializedName("NickName")
    public String nickName;
    @SerializedName("TrueName")
    public String trueName;
    @SerializedName("MemberType")
    public int memberType; // 是不是成为合伙人（1是0不是）
    @SerializedName("AuditStateVal")
    public int auditStateVal; //申请状态值（ 1通过 2失败 3审核中 4是刚刚提交）
    @SerializedName("AuditState")
    public String auditState; // AuditStateVal 合伙人状态说明
    @SerializedName("Level")
    public int level;
    @SerializedName("Mobile")
    public String mobileStr;
    @SerializedName("Sex")
    public int sex; // 性别值（1男2女0保密）
    @SerializedName("BorthDate")
    public String birthday;
    @SerializedName("Code")
    public String code;
    @SerializedName("PayNum")
    public String payNum; // PayNum 支付宝账号
    @SerializedName("PayName")
    public String payName; // PayName 支付宝名称
}
