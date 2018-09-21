package com.ray.test07.zuoye;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 	3.给一个类的对象，动态生成代理对象，对传入的类实现的所有的接口都进行代理，
 * 	  实现输入方法执行时间的功能
 */
public class Interfacetimeproxy {
    public static List<Class> classlist = new ArrayList<>();
    public static HashSet<Class> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        final A a = new A();
        Class clz = a.getClass();
        int i = 0 ;
        HashSet<Class> set = getinterfacesm(clz);
        Class[] c = new Class[set.size()];
        Iterator<Class> it = set.iterator();
        while(it.hasNext()){
            c[i] = it.next();
            i++;
        }

/*        while(clz != Object.class){
            if(clz.getInterfaces().length > 0){
                classlist.add(clz);
            }
            clz = clz.getSuperclass();
        }*/
    //    for(int i = 0 ; i < classlist.size();i++){
           // final int i2 = i;
/*            final Constructor cons = classlist.get(i2).getDeclaredConstructor();
            cons.setAccessible(true);*/

            InvocationHandler hand = new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    long start = System.currentTimeMillis();
                    Object ret = method.invoke(a, args);
                    System.out.println("时间:" + (System.currentTimeMillis() - start) );
                    return ret;
                }
            };
            Object o = Proxy.newProxyInstance(Interfacetimeproxy.class.getClassLoader(),c , hand);

        D d = (D)o;
        d.D_say();
        E e = (E)o;
        e.E_say();
        F f = (F)o;
        f.F_say();
  //      }
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
