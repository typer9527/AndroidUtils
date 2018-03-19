package com.yl.androidutils.utils.model;

import com.google.gson.annotations.SerializedName;

/**
 * 忘记密码时短信验证参数
 * Created by Administrator on 2018/3/9.
 */

public class VerifyPwdBean {
    @SerializedName("rand")
    public int rand;
}
