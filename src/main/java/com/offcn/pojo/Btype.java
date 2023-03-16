package com.offcn.pojo;

import java.util.List;

public class Btype {
    private Integer typeid;

    private String typename;

    private Integer typePid;

    private String typedes;

    //一对多  一个大类可以包含多个小类
    private List<Btype> child;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getTypePid() {
        return typePid;
    }

    public void setTypePid(Integer typePid) {
        this.typePid = typePid;
    }

    public String getTypedes() {
        return typedes;
    }

    public void setTypedes(String typedes) {
        this.typedes = typedes;
    }

    public List<Btype> getChild() {
        return child;
    }

    public void setChild(List<Btype> child) {
        this.child = child;
    }
}