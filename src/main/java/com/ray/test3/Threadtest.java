package com.ray.test3;

/**
 * 30个人吃100馒头,每人最少一个,最多4个,满足上述条件 尽快吃完
 * 70 3 23
 * 92
 */
public class Threadtest {
    public static void main(String[] args) {
        bun bun = new bun();
        for (int i = 1; i <= 30; i++) {
            monk monk = new monk("man" + i, bun);
            monk.start();
        }
    }
}
