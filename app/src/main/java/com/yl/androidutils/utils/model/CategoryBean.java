package com.yl.androidutils.utils.model;

import java.io.Serializable;
import java.util.List;

/**
 * 首页TabLayout分类
 * Created by LuoYaWei on 2018/3/12.
 */

public class CategoryBean implements Serializable{


    /**
     * Name : 女装
     * Icon : http://localhost:10020/Upload/image/2017-09-27/59cb685218cfa.png
     * ID : 4
     * Type : 2
     * Children : []
     */

    private String Name;
    private String Icon;
    private String ID;
    private int Type;
    private List<?> Children;

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

    public List<?> getChildren() {
        return Children;
    }

    public void setChildren(List<?> Children) {
        this.Children = Children;
    }
}
