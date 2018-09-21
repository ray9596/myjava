package com.ray.test4;

import org.junit.Test;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class day04test {
    /**
     *写入10w数据 用randowfile和mappedbytebuffer并比较
     *
     */
    @Test
    public void writefile() throws Exception {
        File f = new File("G:\\bigdata\\day04\\100.txt");
        long len = f.length();
        RandomAccessFile rf = new RandomAccessFile(f, "rw");
        long start = System.currentTimeMillis();
        byte[] buf = new byte[1024];
        for(int i = 0 ;i <len; i++){
            rf.write((i+"\r\n").getBytes());
        }
        rf.close();
        System.out.println("RandomAccessFile:"+ (System.currentTimeMillis() - start));
    }
    //零拷贝
    //transferTo:3
    //transferTo:16120
    @Test
    public void writefile2() throws Exception {
        File f = new File("G:\\bigdata\\day04\\200.txt");
        long len =  f.length();
        FileInputStream fis = new FileInputStream(f);
        FileChannel infc = fis.getChannel();
        FileOutputStream fos = new FileOutputStream("G:\\bigdata\\day04\\200_2.txt");
        FileChannel outfc = fos.getChannel();
        long start = System.currentTimeMillis();
        //只能写int最大值
        infc.transferTo(0,len,outfc);
        System.out.println("transferTo:"+ (System.currentTimeMillis() - start));
    }
    //MappedByteBuffer:10
    //MappedByteBuffer:5750
    @Test
    public void writefile3() throws Exception {
        File f = new File("G:\\bigdata\\day04\\200.txt");
        long len =  f.length();
        RandomAccessFile fis = new RandomAccessFile(f,"r");
        FileChannel infc = fis.getChannel();
        //最大只能映射int的最大值
        MappedByteBuffer mapin = infc.map(FileChannel.MapMode.READ_ONLY, 0, len);
        RandomAccessFile fos = new RandomAccessFile("G:\\bigdata\\day04\\300.txt","rw");
        FileChannel outfc = fos.getChannel();
        MappedByteBuffer mapout = outfc.map(FileChannel.MapMode.READ_WRITE, 0, len);
        byte[] byt = new byte[(int) len -2 ];
        int len2 = 0;
        long start = System.currentTimeMillis();
        for(long i = 0 ;i <len ;i++){
            byte b = mapin.get();
            mapout.put(b);
        }
        fis.close();
        infc.close();
        fos.close();
        outfc.close();
        System.out.println("MappedByteBuffer:"+ (System.currentTimeMillis() - start));
    }
    //RandomAccessFile:2
    //RandomAccessFile:59693

    @Test
    public void whritefile4() throws IOException {
        File f = new File("G:\\bigdata\\day04\\200.txt");
        long len =  f.length();
        RandomAccessFile fis = new RandomAccessFile(f,"r");
        RandomAccessFile fos = new RandomAccessFile("G:\\bigdata\\day04\\400.txt","rw");
        byte[] byt = new byte[(int) len -2];
        int len2 = 0;
        long start = System.currentTimeMillis();
        while ( (len2 = fis.read(byt)) != -1) {
            fos.write(byt,0,len2);
        }
        fis.close();
        fos.close();
        System.out.println("RandomAccessFile:"+ (System.currentTimeMillis() - start));
    }
}
