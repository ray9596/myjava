package com.ray.test6;

import com.ray.test2.zPerson;
import com.ray.test2.zPerson2;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 	1.对象属性的复制
 * 		//类型相同,反射实现
 * 		public static void copyProperties1(Object a , Object b) ;
 *
 *
 * 		//类型不同,反射
 * 		public static void copyProperties2(Object a , Object b) ;
 */
public class Reflecttest {
    @Test
    public  void testfield() throws Exception {
        Class clazz = Class.forName("com.ray.test2.zPerson");

        Constructor cons = clazz.getDeclaredConstructor();
        cons.setAccessible(true);
        Object o = cons.newInstance();

        //Field[] fields = clazz.getDeclaredFields();
        Field fname = clazz.getDeclaredField("age");
        fname.setAccessible(true);
        //fname.set(o,"1");
        zPerson p = (zPerson) o;
        System.out.println("age:" + p.getAge());
    }
    @Test
    public  void copyProperties() throws Exception {
        Class clazz = Class.forName("com.ray.test2.zPerson");
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object o = constructor.newInstance();
        zPerson2 p = new zPerson2(180,150,"23",true);
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(o,p.getAge());
        Field height = clazz.getDeclaredField("height");
        height.setAccessible(true);
        height.set(o,p.getHeight());
        Field weight = clazz.getDeclaredField("weight");
        weight.setAccessible(true);
        weight.set(o,p.getWeight());
        Field blood = clazz.getDeclaredField("blood");
        blood.setAccessible(true);
        blood.set(o,p.isBlood());
        zPerson2 p2 = (zPerson2) o;
        System.out.println(o.toString());

    }
    @Test
    public void testcopy() throws Exception {
        zPerson p1 = new zPerson(180,160,23,1);

        zPerson2 p2 = new zPerson2();
        //类型不同
     //   copyProperties2(p1,p2);
        //类型相同
       // copyProperties1(p1,p2);
        //hashmap
      //  copyProperties3(p1,p2);
        //内省复制有父类的javabean
      //  copyProperties4(p1,p2);
        //内省 降低时间复杂度
        copyProperties5(p1,p2);
        System.out.println(p2.toString());

    }
    public static void copyProperties3(Object o1 , Object o2) throws Exception {
        Class clz1 = o1.getClass();
        Class clz2 = o2.getClass();
/*        if(clz1 !=clz2){
            throw new RuntimeException("类型不同异常");
        }*/
        //存放o1的属性,减少一次for的嵌套循环提升效率
        Map<String , Field> map = new HashMap<>();

        Field[] fields1 = clz1.getDeclaredFields();
        Field[] fields2 = clz2.getDeclaredFields();

        for (Field field1 : fields1) {
            field1.setAccessible(true);
            //Object value = field1.get(o1);
            String name1 = field1.getName();
            //Class type1 = field1.getType();
            map.put(name1,field1);
        }

        for (Field field2 : fields2) {
            field2.setAccessible(true);
            String name2 = field2.getName();
            Class type2 = field2.getType();
            if(map.containsKey(name2) && map.get(name2).getType() == type2){
                field2.set(o2,map.get(name2).get(o1));
            }


        }

    }
    public static void copyProperties2(Object o1 , Object o2) throws Exception {
        Class clz1 = o1.getClass();
        Class clz2 = o2.getClass();
/*        if(clz1 !=clz2){
            throw new RuntimeException("类型不同异常");
        }*/
        Field[] fields = clz1.getDeclaredFields();
        Field[] fields2 = clz2.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Class type = field.getType();
            Object value = field.get(o1);
            for (Field field2 : fields2) {
                field2.setAccessible(true);
                String name2 = field2.getName();
                Class type2 = field2.getType();
                //相同才复制
                if(name == name2 && type ==type2){
                    field2.set(o2,value);
                }
            }
        }

    }
    public static void copyProperties1(Object o1 , Object o2) throws Exception {
        Class clz1 = o1.getClass();
        Class clz2 = o2.getClass();
        if(clz1 !=clz2){
            throw new RuntimeException("类型不同异常");
        }
        Field[] fields = clz1.getDeclaredFields();
        Field[] fields2 = clz2.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(o1);
            for(Field field2 : fields2){
                field2.setAccessible(true);
                field2.set(o2,value);
            }
        }

    }
    public static void copyProperties4(Object o1 , Object o2) throws Exception {
        Class clz1 = o1.getClass();
        Class clz2 = o2.getClass();
/*        if(clz1 !=clz2){
            throw new RuntimeException("类型不同异常");
        }*/
        //内省
        BeanInfo b1 = Introspector.getBeanInfo(clz1);
        BeanInfo b2 = Introspector.getBeanInfo(clz2);
        //得到属性描述符集合
        PropertyDescriptor[] descriptors = b1.getPropertyDescriptors();
        PropertyDescriptor[] descriptors2 = b2.getPropertyDescriptors();

        for (PropertyDescriptor descriptor : descriptors) {
            String name1 = descriptor.getName();
            //System.out.println(name1);
            Class type1 = descriptor.getPropertyType();
            Method readMethod1 = descriptor.getReadMethod();
            if(readMethod1 != null){
                Object value = readMethod1.invoke(o1);
                //System.out.println(value);
                for(PropertyDescriptor descriptor2 : descriptors2){
                    String name2 = descriptor2.getName();
                    //System.out.println(name2);
                    Class type2 = descriptor2.getPropertyType();
                    Method writeMethod = descriptor2.getWriteMethod();
                    System.out.println(name1 + ":" + name2);
                    System.out.println(name1 == name2);
                    //System.out.println(type1+":"+type2);
                    //System.out.println(writeMethod);
                    if(writeMethod != null && name1.equals(name2) && type1 ==type2 ){
                        //     descriptor2.setValue(name2,value);
                        writeMethod.invoke(o2,value);
                    }
                }
                System.out.println("-----------------");
            }
        }


    }
    public static void copyProperties5(Object o1 , Object o2) throws Exception {
        Class clz1 = o1.getClass();
        Class clz2 = o2.getClass();
        BeanInfo b1 = Introspector.getBeanInfo(clz1);
        BeanInfo b2 = Introspector.getBeanInfo(clz2);
        PropertyDescriptor[] descriptors = b1.getPropertyDescriptors();
        Map<String , PropertyDescriptor> map = new HashMap<>();
        for (PropertyDescriptor descriptor : descriptors) {
            String name1 = descriptor.getName();
            Class type1 = descriptor.getPropertyType();
            Method readMethod = descriptor.getReadMethod();
            if(readMethod != null){
                map.put(name1,descriptor);
               // Object value = readMethod.invoke(o1,name1);
            }
        }
        PropertyDescriptor[] descriptors2 = b2.getPropertyDescriptors();
        for(PropertyDescriptor descriptor2 : descriptors2){
            String name2 = descriptor2.getName();
            Class type2 = descriptor2.getPropertyType();
            Method writeMethod = descriptor2.getWriteMethod();
            if(writeMethod != null && map.containsKey(name2) && map.get(name2).getPropertyType() ==type2){
                writeMethod.invoke(o2,map.get(name2).getReadMethod().invoke(o1));

            }
        }

    }
}
