package com.ray.test4.reentrantlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class locktest {
    public static void main(String[] args) {
        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        new Thread(){
            @Override
            public void run() {
                lock.writeLock().lock();
                System.out.println("xxx");
                lock.writeLock().unlock();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                lock.writeLock().lock();
                System.out.println("yyy");
                lock.writeLock().unlock();
            }
        }.start();
    }
}
