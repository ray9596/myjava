package com;

public class test2 {
    public static void main(String[] args) {
        byte[] a = {1,2,3,'A','a',};
        for(int i = 0 ; i< a.length ;i++){
            System.out.println(a[i]);
        }
        a[3] = (byte) -a[3];
        System.out.println(a[3]);
    }
}
