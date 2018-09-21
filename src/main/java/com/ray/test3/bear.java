package com.ray.test3;

public class bear extends Thread {
    private String bname;
    private honeypot pot;

    public bear(String bname, honeypot pot) {
        this.bname = bname;
        this.pot = pot;
    }

    @Override
    public void run() {
        while (true) {
            pot.eat(bname);
        }

    }
}
