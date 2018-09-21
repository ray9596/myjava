package com.ray.test4.sellticket;

public class picket {
    public static int count = 1000000;


    public synchronized void reduce(String name){
        if(count >0){
            count--;
            //System.out.println(name +":"+ count);
        }
    }
}
