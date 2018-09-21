package com.ray.test4.sellticket;

public class passenger extends Thread{
    private String name;
    private picket picket;
    public passenger(String name , picket picket){
        this.name = name;
        this.picket = picket;
    }
    @Override
    public void run() {


    }
}
