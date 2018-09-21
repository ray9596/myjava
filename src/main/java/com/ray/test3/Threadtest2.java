package com.ray.test3;

/**
 * 	1.熊吃蜂蜜问题
 * 		两只熊，100只蜜蜂，蜜蜂每次生产的蜂蜜量是1，罐子的容量是30，熊在罐子的蜂蜜量达到20的时候，
 * 		一次性将蜂蜜吃光。
 */
public class Threadtest2 {
    public static void main(String[] args) {
        honeypot pot = new honeypot();
        bear b1 = new bear("b1",pot);
        bear b2 = new bear("b2",pot);
        b1.start();
        b2.start();
        for(int i= 1 ;i<=100;i++ ){
            bee bee = new bee("bee"+i,pot);
            bee.start();
        }
    }
}
