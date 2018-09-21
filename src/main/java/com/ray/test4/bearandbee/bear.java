package com.ray.test4.bearandbee;

public class bear extends Thread{
    private String bname;
    private honeypot pot;
    public bear(String bname , honeypot pot){
        this.bname = bname;
        this.pot = pot;
    }

    @Override
    public void run() {
        while(true){
            pot.removehoney(bname);
        }

    }
}
