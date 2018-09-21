package com.ray.test4.sellticket;

import java.util.concurrent.locks.ReentrantLock;

public class picket2 {
    public static int count = 1000000;
    ReentrantLock lock = new ReentrantLock(false);

    public void reduce(String name){
        try {
            lock.lock();
            if(count > 0){
                count--;
                //System.out.println(name + ":" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            lock.unlock();
        }

    }
}
