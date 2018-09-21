package com.ray.test3;

public class bee extends Thread {
    private String beename ;
    private honeypot pot;
    public bee(String beename,honeypot pot){
        this.beename = beename;
        this.pot = pot;
    }
    @Override
    public void run() {
        while(true){
            pot.produce(beename);
        }

    }
}
