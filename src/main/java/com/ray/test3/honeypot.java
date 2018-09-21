package com.ray.test3;

public class honeypot {
    private final int MAX = 30;
    private int count = 0;
    public synchronized void eat(String name){
        if(count >= 20){
            count = count - 20 ;
            System.out.println(name + ".eat" + count);
            this.notify();
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void produce(String name){
        if(count < 30){
            count++;
            System.out.println(name + ".produce" + count);
            if(count >= 20){
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
