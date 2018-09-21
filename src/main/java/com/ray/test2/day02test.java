package com.ray.test2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class day02test {
    @Test
    public void arraylisttest(){
        long start = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < 1000000;i++){
            //必须索引为0
            list.add(0,i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    @Test
    public void linkedlisttest(){
        long start = System.currentTimeMillis();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0 ; i < 1000000;i++){
            list.add(0,i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    @Test
    public void arraylistread(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < 1000000;i++){
            list.add(0,i);
        }
        long start = System.currentTimeMillis();
        System.out.println(list.get(500000));
        System.out.println(System.currentTimeMillis() - start);
    }
    @Test
    public void linkedlistread(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0 ; i < 1000000;i++){
            list.add(0,i);
        }
        long start = System.currentTimeMillis();
        System.out.println(list.get(500000));
        System.out.println(System.currentTimeMillis() - start);
    }
    @Test
    public void hashmaptest(){
        HashMap<Mykey, Integer> map = new HashMap<>();
        map.put(new Mykey(0),1);
        map.put(new Mykey(16),1);
        map.put(new Mykey(32),1);

        System.out.println(map.size());
        System.out.println(map);
    }

    @Test
    public void newhashtest(){
        zPerson zp1 = new zPerson(226,180,23,2);
        zPerson zp2 = new zPerson(227,180,27,1);
        zPerson zp3 = new zPerson(228,180,26,4);
        zPerson zp4 = new zPerson(223,180,21,1);
        zPerson zp5 = new zPerson(216,180,34,4);
        System.out.println(zp1.hashCode());
        System.out.println(zp2.hashCode());
        System.out.println(zp3.hashCode());
        System.out.println(zp4.hashCode());
        System.out.println(zp5.hashCode());

    }
}
