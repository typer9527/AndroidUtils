package com.yl.androidutils.app.model;

import com.google.gson.annotations.SerializedName;

/**
 * 图片上传的返回结果
 * Created by Yangli on 2018/3/13.
 */

public class UploadImgBean {
    @SerializedName("result")
    public int result;
    @SerializedName("message")
    public String message;
    @SerializedName("path")
    public String path;
    @SerializedName("loadpath")
    public String loadpath;

    @Override
    public String toString() {
        return "UploadImgBean{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", filePath='" + loadpath + '\'' +
                '}';
    }
}
