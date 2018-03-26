package com.yl.androidutils.app.model;

import java.io.Serializable;

/**
 * 限时抢购列表
 * Created by LuoYaWei on 2018/3/20.
 */

public class TimeGoodsBean implements Serializable {


    /**
     * click_url : https://s.click.taobao.com/t?e=m%3D2%26s%3DeGZaSZGTw%2FocQipKwQzePOeEDrYVVa64yK8Cckff7TVRAdhuF14FMcGoQGKo2cm1RitN3%2FurF3yyXjHjBVPM6Lr4IGAHTRzgahnk5Xt4vwuvw2YFOqBnBXbOdFtc4uDS06qvb4lce%2B9TX8ze124PMgOvdF%2Ffxpd9Dt6his2RlEgoXGyhbA9A8SUT8OESphf401g1tCjq9uI9peD8rCcfzw%3D%3D
     * end_time : 2018-03-16 23:59:59
     * num_iid : 524046970167
     * pic_url : http://img4.tbcdn.cn/tfscom///gju4.alicdn.com/tps/i3/111000329545303604/TB2eXkZd4mI.eBjy0FlXXbgkVXa_!!0-juitemmedia.jpg
     * reserve_price : 59.00
     * sold_num : 0
     * start_time : 2018-03-16 00:00:00
     * title : 2个装小麦倒扣沥水防霉漱口杯
     * total_amount : 2500
     * zk_final_price : 6.8
     */

    private String click_url;
    private String end_time;
    private String num_iid;
    private String pic_url;
    private String reserve_price;
    private String sold_num;
    private String start_time;
    private String title;
    private String total_amount;
    private String zk_final_price;

    public String getClick_url() {
        return click_url;
    }

    public void setClick_url(String click_url) {
        this.click_url = click_url;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(String num_iid) {
        this.num_iid = num_iid;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getReserve_price() {
        return reserve_price;
    }

    public void setReserve_price(String reserve_price) {
        this.reserve_price = reserve_price;
    }

    public String getSold_num() {
        return sold_num;
    }

    public void setSold_num(String sold_num) {
        this.sold_num = sold_num;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getZk_final_price() {
        return zk_final_price;
    }

    public void setZk_final_price(String zk_final_price) {
        this.zk_final_price = zk_final_price;
    }
}
