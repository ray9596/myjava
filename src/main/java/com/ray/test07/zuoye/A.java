package com.ray.test07.zuoye;

public class A extends B implements D ,E {

    @Override
    public void E_say() {
        System.out.println(A.class.getName() + "say()...");
    }
}
