package com.ray.test4;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class niotest {
    @Test
    public void readandwrite() throws Exception {
        FileInputStream fis = new FileInputStream("G:\\bigdata\\day04\\1.txt");
        FileChannel incha = fis.getChannel();
        FileOutputStream fos = new FileOutputStream("G:\\bigdata\\day04\\10.txt");
        FileChannel outcha = fos.getChannel();
        //缓冲区
        ByteBuffer buf = ByteBuffer.allocate(12);
        while( (incha.read(buf)) != -1 ){
            //拍板, 读完之后的写
          //  buf.flip();
            outcha.write(buf);
            //清空 , 重写
            buf.clear();
        }
        //标记当前指针  从0开始
        buf.position(2);
        buf.mark();
        System.out.println((char) buf.get());
        fos.close();
        fis.close();
        outcha.close();
        incha.close();
    }
}
