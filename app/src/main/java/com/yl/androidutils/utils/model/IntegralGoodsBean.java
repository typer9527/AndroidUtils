package com.yl.androidutils.utils.model;

import java.io.Serializable;

/**
 * Created by LuoYaWei on 2018/3/15.
 */

public class IntegralGoodsBean implements Serializable{


    /**
     * ID : 16
     * Pic : http://localhost:10020/Upload/image/2018-01-21/5a643078c71d1.jpg
     * Name : 30元话费充值移动联通电信
     * Point : 30
     * Orders : 3
     * Price :  0
     */

    private String ID;
    private String Pic;
    private String Name;
    private String Point;
    private String Orders;
    private String Price;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String Pic) {
        this.Pic = Pic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPoint() {
        return Point;
    }

    public void setPoint(String Point) {
        this.Point = Point;
    }

    public String getOrders() {
        return Orders;
    }

    public void setOrders(String Orders) {
        this.Orders = Orders;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
}
