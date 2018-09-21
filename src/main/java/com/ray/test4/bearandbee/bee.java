package com.ray.test4.bearandbee;

import java.util.Random;

public class bee extends Thread {

    private honeypot pot;
    private String beename;
    private int[] honeynumarr = {1, 2, 3, 4, 5};
    private int honeynum = 0;
    Random r = new Random();

    public bee(String beename, honeypot pot) {
        this.beename = beename;
        this.pot = pot;
    }

    @Override
    public void run() {
        while (true) {
            if (this.honeynum != 0) {
                pot.addhoney(honeynum,beename);
            }else {
                pot.addhoney(honeynumarr[r.nextInt(5)],beename);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
