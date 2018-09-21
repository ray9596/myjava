package com.ray.test6.poxy;

public class wsimpl implements ws1,ws2 {
    @Override
    public void a1() {
        System.out.println("a1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void a2() {
        System.out.println("a2");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void a3() {
        System.out.println("a3");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
