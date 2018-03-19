package com.yl.androidutils.utils.model;

import java.io.Serializable;

/**
 * 积分商品创建订单返回信息订单实体
 * Created by LuoYaWei on 2018/3/16.
 */

public class CreateOrderResBean implements Serializable {

    /**
     * child : 0
     * id : 1
     * orderno : 123456789
     */

    private int child;
    private int id;
    private String orderno;

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }
}
