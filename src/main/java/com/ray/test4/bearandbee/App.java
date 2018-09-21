package com.ray.test4.bearandbee;

/**
 * 两只熊，100只蜜蜂，蜜蜂每次生产的蜂蜜量是1到5不等，罐子的容量是30，熊在罐子的蜂蜜量达到20的时候，一次性将蜂蜜吃光，
 * 		蜜蜂向罐子中添加尽可能的蜂蜜，如果有剩余的话，下次继续添加剩余的量。
 */
public class App {
    public static void main(String[] args) {
        honeypot pot = new honeypot();
        bear bear1 = new bear("bear1", pot);
        bear bear2 = new bear("bear2", pot);
        bear1.start();
        bear2.start();
        for(int i = 1 ; i <=100;i++){
            new bee("bee"+i,pot).start();
        }
    }
}
