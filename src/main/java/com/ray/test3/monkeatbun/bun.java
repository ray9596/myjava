package com.ray.test3.monkeatbun;

public class bun {
    private int numb = 100;
    private int numm = 30;

    public synchronized int reduce(monk m){
        if(m.count == 0){
            //还有多少和尚一个也没吃
            int temp = numb;
            numb--;
            numm--;
            return temp;
        }else if(m.count < monk.MAX){
            if(numb > numm){
                int temp = numb;
                numb--;
                return temp;
            }
        }
        return -1;
    }

}
