package com.yl.androidutils.app.model;

import java.io.Serializable;
import java.util.List;

/**
 * 首页TabLayout分类
 * Created by LuoYaWei on 2018/3/12.
 */

public class CategoryBean implements Serializable{


    /**
     * Name : 女装
     * Icon : http://hlg.ahceshi.com/Upload/image/2018-03-10/5aa39e6a01f3b.png
     * curricon : http://hlg.ahceshi.com/Upload/image/2018-03-10/5aa39e6a01f3b.png
     * ID : 4
     * Type : 2
     * Children : [{"Name":"连衣裙","Icon":"http://hlg.ahceshi.com/Upload/no.png","curricon":"http://hlg.ahceshi.com/Upload/no.png","ID":"131","Type":2},{"Name":"上衣","Icon":"http://hlg.ahceshi.com/Upload/no.png","curricon":"http://hlg.ahceshi.com/Upload/no.png","ID":"130","Type":2}]
     */

    private String Name;
    private String Icon;
    private String curricon;
    private String ID;
    private int Type;
    private List<ChildrenBean> Children;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String Icon) {
        this.Icon = Icon;
    }

    public String getCurricon() {
        return curricon;
    }

    public void setCurricon(String curricon) {
        this.curricon = curricon;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public List<ChildrenBean> getChildren() {
        return Children;
    }

    public void setChildren(List<ChildrenBean> Children) {
        this.Children = Children;
    }

    public static class ChildrenBean implements  Serializable{
        /**
         * Name : 连衣裙
         * Icon : http://hlg.ahceshi.com/Upload/no.png
         * curricon : http://hlg.ahceshi.com/Upload/no.png
         * ID : 131
         * Type : 2
         */

        private String Name;
        private String Icon;
        private String curricon;
        private String ID;
        private int Type;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getIcon() {
            return Icon;
        }

        public void setIcon(String Icon) {
            this.Icon = Icon;
        }

        public String getCurricon() {
            return curricon;
        }

        public void setCurricon(String curricon) {
            this.curricon = curricon;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public int getType() {
            return Type;
        }

        public void setType(int Type) {
            this.Type = Type;
        }
    }
}
