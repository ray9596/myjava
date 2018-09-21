package com.ray.test6.poxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class wspoxy  {
    public static void main(String[] args) {
        final wsimpl wsimpl = new wsimpl();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class[] inters = {ws1.class,ws2.class};
        long start = 0;
        long sum = 0;
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long start = System.currentTimeMillis();

                Object ret = method.invoke(wsimpl, args);
                System.out.println("时间:" + (System.currentTimeMillis() - start) );
                return ret;
            }
        };
        //一个代理对象  需要将其强转
        Object o =  Proxy.newProxyInstance(classLoader, inters, handler);
        ws1 o1 = (ws1) o;
        o1.a1();
        ws2 o2 = (ws2) o;
        o2.a2();
        o2.a3();

    }

}
