package com.ray.test07.zuoye;

import java.util.HashSet;
import java.util.Iterator;

/*
    提取一个类实现的所有接口，包括父类实现接口以及接口继承的接口
 */
public class getinterfaces {
    public static HashSet<Class> set = new HashSet<>();
    public static void main(String[] args) {

        HashSet<Class> set = getinterfacesm(A.class);
        Iterator<Class> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());

        }


    }

    private static HashSet<Class> getinterfacesm(Class a) {

        if(a.getSuperclass() != Object.class){
            getinterfacesm(a.getSuperclass());
        }
        if(a.getInterfaces() != null){
            for(int i = 0 ; i < a.getInterfaces().length;i++){

                set.add(a.getInterfaces()[i]);
            }
        }
        return set;
    }
}
