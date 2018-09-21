package com.ray.test3;

public class Producer extends Thread {
    private String pname ;
    private Pool p;
    public Producer(String pname , Pool p){
        this.pname = pname;
        this.p = p;
    }
    @Override
    public void run() {
        try {
            while(true){

                p.put();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
