package com.ray.test4.sellticket;

/**
 * synchronize | ReentrantLock ;两个售票员一起买100000张票，使用两种加锁方式，看性能比对.
 * ReentrantLock:55 64  58
 *synchronized:78   66  69
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        picket picket = new picket();
        picket2 picket2 = new picket2();
        seller seller1 = new seller("seller1", picket2);
        seller seller2 = new seller("seller2", picket2);
        seller seller3 = new seller("seller3", picket2);
        seller seller4 = new seller("seller4", picket2);
        long start = System.currentTimeMillis();
        seller1.start();
        seller2.start();
        seller3.start();
        seller4.start();
        seller1.join();
        seller2.join();
        seller3.join();
        seller4.join();
        System.out.println("------------------------------------------------------");
        System.out.println("ReentrantLock:" + (System.currentTimeMillis() - start));
        //System.out.println("synchronized:" + (System.currentTimeMillis() - start));

    }
}
