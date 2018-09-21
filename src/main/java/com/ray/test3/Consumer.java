package com.ray.test3;

public class Consumer extends Thread {
    private String cname;
    private Pool p;

    public Consumer(String cname, Pool p) {
        this.cname = cname;
        this.p = p;
    }

    @Override
    public void run() {
        try {
            while (true) {
                p.get();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
