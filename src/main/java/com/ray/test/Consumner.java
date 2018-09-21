package com.ray.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Consumner implements Serializable {
    static final long serialVersionUID = 123456;
    private int id ;
    private String name ;
    private List<Order> olist  = new ArrayList<Order>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOlist() {
        return olist;
    }

    public void setOlist(List<Order> olist) {
        this.olist = olist;
    }
}
