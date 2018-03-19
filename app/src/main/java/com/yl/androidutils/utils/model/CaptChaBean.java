package com.yl.androidutils.utils.model;

import com.google.gson.annotations.SerializedName;

/**
 * 验证码实体类
 * Created by Administrator on 2018/3/8.
 */

public class CaptChaBean {
    @SerializedName("imgPath")
    public String captchaUrl;
}
