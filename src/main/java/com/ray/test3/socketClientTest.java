package com.ray.test3;

import java.io.*;
import java.net.Socket;

public class socketClientTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8888);
        System.out.println("连接到服务器.");

        while(true){
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println("收到消息:"+line);
            }
        }
    }
}
