package com.ray.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
    static final long serialVersionUID = 123457;
    private int oid ;
    private String oname ;
    private List<Item> ilist = new ArrayList<Item>();

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public List<Item> getIlist() {
        return ilist;
    }

    public void setIlist(List<Item> ilist) {
        this.ilist = ilist;
    }
}
