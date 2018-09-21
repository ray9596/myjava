package com.ray.test3;

public class Pool {
    //为了产生死锁
    private static final int MAX = 50;
    private static int thing = 0;
    //类的.class
    public static synchronized void get() throws InterruptedException {
        if(thing >0){
            System.out.println(Thread.currentThread().getName()+".get");
            thing--;
            System.out.println(Thread.currentThread().getName()+".notify");
          //  this.notify();
        }else {
            System.out.println(Thread.currentThread().getName()+".wait");
           // this.wait();
        }

    }
    //类的对象
    public synchronized void put() throws InterruptedException {
        if(thing >= MAX){
            System.out.println(Thread.currentThread().getName()+".wait");
           // this.wait();
        }else {
            System.out.println(Thread.currentThread().getName() + ".put");
            thing++;
            System.out.println(Thread.currentThread().getName() + ".notify");
          //  this.notify();
        }

    }
}
