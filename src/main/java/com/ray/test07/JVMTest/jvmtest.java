package com.ray.test07.JVMTest;

import org.junit.Test;
import sun.misc.Cleaner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class jvmtest {
    public static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        byte[] buf = new byte[1024 * 1024 * 20];
        List<byte[]> list = new ArrayList<>();
        list.add(buf);
        list.add(buf);
        //年老取
        System.gc();
        byte[] byte2 = buf;
        buf = null;
        //不回收
        System.gc();
        list.remove(0);
        //回收
        System.gc();
        list.remove(0);
        //回收
        System.gc();
        byte2 = null;
        System.gc();

    }
    public static void t1() throws InterruptedException {
        i++;
        System.out.println(i);
        t1();
        Thread.sleep(1000);
    }
    //零拷贝复制
    //零拷贝:15674
    //
    @Test
    public void zerocopyfile() throws Exception {
        File f = new File("G:\\bigdata\\day07\\300.txt");
        long size = f.length();
        ByteBuffer byf = ByteBuffer.allocate(1024 * 1024 * 500);
        FileInputStream fis = new FileInputStream(f);
        FileChannel in = fis.getChannel();
        FileOutputStream fos = new FileOutputStream("G:\\bigdata\\day07\\500.txt");
        FileChannel out = fos.getChannel();
        long start = System.currentTimeMillis();
        in.transferTo(0,size,out);
        System.out.println("零拷贝:"+ (System.currentTimeMillis() - start));
        fos.close();
        fis.close();
        in.close();
        out.close();
    }
    //堆内存文件复制
    //堆内存:67586
    @Test
    public void heapcopyfile() throws IOException {
        File f = new File("G:\\bigdata\\day04\\200.txt");
        ByteBuffer byf = ByteBuffer.allocate(1024 * 1024 * 500);
        FileInputStream fis = new FileInputStream(f);
        FileChannel in = fis.getChannel();
        FileOutputStream fos = new FileOutputStream("G:\\bigdata\\day07\\100.txt");
        FileChannel out = fos.getChannel();
        long start = System.currentTimeMillis();
        while( in.read(byf) != -1){
            byf.flip();
            out.write(byf);
            byf.clear();
        }
        System.out.println("堆内存:"+ (System.currentTimeMillis() - start));
        fos.close();
        fis.close();
        in.close();
        out.close();
    }
    //离堆内存文件复制
    //36659
    @Test
    public void offheapcopyfile() throws Exception {
        File f = new File("G:\\bigdata\\day04\\200.txt");
        ByteBuffer byf = ByteBuffer.allocateDirect(1024 * 1024 * 500);

        FileInputStream fis = new FileInputStream(f);
        FileChannel in = fis.getChannel();
        FileOutputStream fos = new FileOutputStream("G:\\bigdata\\day07\\200.txt");
        FileChannel out = fos.getChannel();
        long start = System.currentTimeMillis();
        while( in.read(byf) != -1){
            byf.flip();
            out.write(byf);
            byf.clear();
        }
        Field field = byf.getClass().getDeclaredField("cleaner");
        field.setAccessible(true);
        Object c = field.get(byf);
        ((Cleaner)c).clean();
        System.out.println("离堆内存:"+ (System.currentTimeMillis() - start));
        fos.close();
        fis.close();
        in.close();
        out.close();

    }
    @Test
    public void classloadertest() throws ClassNotFoundException {
        ClassLoader a1 = Class.forName("com.ray.test2.zPerson2").getClassLoader();
        ClassLoader a2 = a1.getParent();
        ClassLoader a3 = a2.getParent();
        System.out.println();

    }
}
