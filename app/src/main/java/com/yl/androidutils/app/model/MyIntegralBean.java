package com.yl.androidutils.app.model;

import java.io.Serializable;
import java.util.List;

/**
 * 我的积分页面实体
 * Created by LuoYaWei on 2018/3/21.
 */

public class MyIntegralBean implements Serializable {


    /**
     * points : [{"Type":"3","ID":"1","Score":"-30.00","UpdateTime":"2018-02-24 17:03:26","Description":"兑换商品(30元话费充值移动联通电信),需30积分"}]
     * curpoint : 99970.00
     * arrivepoint : 0.00
     */

    private String curpoint;
    private String arrivepoint;
    private List<PointsBean> points;

    public String getCurpoint() {
        return curpoint;
    }

    public void setCurpoint(String curpoint) {
        this.curpoint = curpoint;
    }

    public String getArrivepoint() {
        return arrivepoint;
    }

    public void setArrivepoint(String arrivepoint) {
        this.arrivepoint = arrivepoint;
    }

    public List<PointsBean> getPoints() {
        return points;
    }

    public void setPoints(List<PointsBean> points) {
        this.points = points;
    }

    public static class PointsBean {
        /**
         * Type : 3
         * ID : 1
         * Score : -30.00
         * UpdateTime : 2018-02-24 17:03:26
         * Description : 兑换商品(30元话费充值移动联通电信),需30积分
         */

        private String Type;
        private String ID;
        private String Score;
        private String UpdateTime;
        private String Description;

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getScore() {
            return Score;
        }

        public void setScore(String Score) {
            this.Score = Score;
        }

        public String getUpdateTime() {
            return UpdateTime;
        }

        public void setUpdateTime(String UpdateTime) {
            this.UpdateTime = UpdateTime;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String Description) {
            this.Description = Description;
        }
    }
}
