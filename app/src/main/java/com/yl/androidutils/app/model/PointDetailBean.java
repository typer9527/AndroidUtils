package com.yl.androidutils.app.model;

import java.io.Serializable;

/**
 * Created by LuoYaWei on 2018/3/21.
 */

public class PointDetailBean implements Serializable {


    /**
     * TradeCode : J1519463006_7295
     * Type : 3
     * TypeVal: 未到账
     * TypeFal 支出
     * Score : 30.00
     * CurrentScore : 100000.00
     * Description : 兑换商品(30元话费充值移动联通电信),需30积分
     * UpdateTime : 2018-02-24 17:03:26
     */

    private String TradeCode;
    private String Type;
    private String TypeVal;
    private String TypeFal;
    private String Score;
    private String CurrentScore;
    private String Description;
    private String UpdateTime;

    public String getTradeCode() {
        return TradeCode;
    }

    public void setTradeCode(String TradeCode) {
        this.TradeCode = TradeCode;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getTypeVal() {
        return TypeVal;
    }

    public void setTypeVal(String typeVal) {
        TypeVal = typeVal;
    }

    public String getTypeFal() {
        return TypeFal;
    }

    public void setTypeFal(String typeFal) {
        TypeFal = typeFal;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String Score) {
        this.Score = Score;
    }

    public String getCurrentScore() {
        return CurrentScore;
    }

    public void setCurrentScore(String CurrentScore) {
        this.CurrentScore = CurrentScore;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }
}
