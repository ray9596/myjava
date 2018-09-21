package com.ray.test3;

//懒汉式   不安全     省资源     反射会将其破坏
public class strictsingleton2 {
    private static strictsingleton2 s = null;

    private strictsingleton2() {
    }

    public static strictsingleton2 newInstances2() {
        if(s != null){
            return s;
        }
        synchronized(strictsingleton2.class){

            if (s == null) {
                s = new strictsingleton2();
            }
        }
        return s;

    }
}
