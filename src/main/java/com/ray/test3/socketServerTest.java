package com.ray.test3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 完善socket通信的MyServer,使用分线程完成和每个client的通信。
 */
public class socketServerTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(8888);
        while(true){
            System.out.println("开始接受连接...");
            Socket socket = ss.accept();
            //发送流
            final OutputStream out = socket.getOutputStream();
            //ip
            String ip2 = ss.getInetAddress().getHostAddress();
            //ip+port
            InetSocketAddress address = (InetSocketAddress) ss.getLocalSocketAddress();
            int port = address.getPort();
            String ip = socket.getInetAddress().getHostAddress();
            //ip
            System.out.println("有人连接" + "IP " + ip + "  Port " + port);
            //分线程向客户端发消息
            new Thread(){
                @Override
                public void run() {
                    int index = 0;
                    while(true){
                        try {
                            out.write(("tom"+index + "\r\t").getBytes());
                            out.flush();
                            index++;
                            Thread.sleep(1000);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }.start();
        }
    }
}
