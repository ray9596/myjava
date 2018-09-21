package com.ray.test;

import java.io.Serializable;

public class Item implements Serializable {
    static final long serialVersionUID = 123458;
    private int id ;
    private String iname ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }
}
