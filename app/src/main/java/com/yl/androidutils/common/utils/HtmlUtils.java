package com.yl.androidutils.common.utils;

/**
 * Created by LuoYaWei on 2018/3/15.
 */

public class HtmlUtils {

    public static String getNewContent(String htmltext) {
        String css = "<style type=\"text/css\"> img {" +
                "width:100%;" +//限定图片宽度填充屏幕
                "height:auto;" +//限定图片高度自动
                "}" +
                "</style>";

        return "<html><header>" + css + "</header>" + htmltext + "</html>";
    }
}
