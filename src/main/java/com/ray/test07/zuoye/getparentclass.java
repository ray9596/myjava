package com.ray.test07.zuoye;

/**
 * 通过反射找到指定类的超类，该超类是Object的第一个子类。
 */
public class getparentclass {
    public static void main(String[] args) {

        Class a = getparent(A.class);
        System.out.println(a.toString());

    }

    private static Class getparent(Class c) {
        while(c.getSuperclass() != Object.class){
            c = c.getSuperclass();
        }
        return c;
    }
}
