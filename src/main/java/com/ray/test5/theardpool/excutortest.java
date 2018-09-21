package com.ray.test5.theardpool;

import java.io.FileOutputStream;
import java.io.IOException;

public class excutortest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("d:/100.txt");
        for(int i = 1; i <= 100;i++){
            byte[] buf = (""+i+"\t\r\n").getBytes();
            fos.write(buf);

        }
        fos.close();
    }
}
