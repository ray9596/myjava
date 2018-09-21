package com.ray.test3;

//饿汉式   安全  占资源
public class strictsingleton {
    private static strictsingleton s = new strictsingleton();
    private strictsingleton(){}
    public static strictsingleton newInstances(){
        return s;
    }

}
