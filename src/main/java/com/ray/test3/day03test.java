package com.ray.test3;



public class day03test {
    public static void main(String[] args) {
        Pool p = new Pool();
        Consumer c1 = new Consumer("c1",p);
        Consumer c2 = new Consumer("c2",p);
        Producer p1 = new Producer("p1",p);
        c1.setName("c1");
        c2.setName("c2");
        p1.setName("p1");
        p1.start();
        c1.start();
        c2.start();

    }
}
