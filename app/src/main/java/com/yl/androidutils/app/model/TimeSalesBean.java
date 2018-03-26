package com.yl.androidutils.app.model;

import java.io.Serializable;

/**
 * Created by LuoYaWei on 2018/3/19.
 */

public class TimeSalesBean implements Serializable {


    /**
     * id : 1
     * name : 09:30
     * notice : 已结束
     */

    private String id;
    private String name;
    private String notice;
    private String iover; // 已结束1 进行中2 即将开抢 0

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getIover() {
        return iover;
    }

    public void setIover(String iover) {
        this.iover = iover;
    }
}
