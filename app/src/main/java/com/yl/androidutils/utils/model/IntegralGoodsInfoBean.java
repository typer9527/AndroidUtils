package com.yl.androidutils.utils.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LuoYaWei on 2018/3/15.
 */

public class IntegralGoodsInfoBean implements Serializable {


    /**
     * ID : 17
     * Name : 50元话费充值移动联通电信
     * Point : 50
     * Price : 0
     * Content :  兑换时请备注需要充值的手机号码，否则将以收货地址上的号码进行充值。
     * other :
     * MainPic : http://hlg.ahceshi.com/Upload/image/2018-03-15/5aaa0d8bc113b.jpg
     * MultiPic : ["http://hlg.ahceshi.com/Upload/image/2018-03-15/5aaa0d8bc113b.jpg"]
     * Orders : 0
     * GoodsNumber : 100
     * Times : 1
     */

    private String ID;
    private String Name;
    private String Point;
    private String Price;
    private String Content;
    private String other;
    private String MainPic;
    private String Orders;
    private String GoodsNumber;
    private String Times;
    private List<String> MultiPic;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getMainPic() {
        return MainPic;
    }

    public void setMainPic(String MainPic) {
        this.MainPic = MainPic;
    }

    public String getOrders() {
        return Orders;
    }

    public void setOrders(String Orders) {
        this.Orders = Orders;
    }

    public String getGoodsNumber() {
        return GoodsNumber;
    }

    public void setGoodsNumber(String GoodsNumber) {
        this.GoodsNumber = GoodsNumber;
    }

    public String getTimes() {
        return Times;
    }

    public void setTimes(String Times) {
        this.Times = Times;
    }

    public List<String> getMultiPic() {
        return MultiPic;
    }

    public void setMultiPic(List<String> MultiPic) {
        this.MultiPic = MultiPic;
    }
}
