package com.yl.androidutils.app.model;

import java.io.Serializable;

/**
 * 筛选-频道实体
 * Created by LuoYaWei on 2018/3/13.
 */

public class PlateBean implements Serializable {


    /**
     * id : 0
     * name : 全部
     */

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
