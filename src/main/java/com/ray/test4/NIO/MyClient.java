package com.ray.test4.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class MyClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        InetSocketAddress address = new InetSocketAddress("localhost", 8888);
        SocketChannel sc = SocketChannel.open(address);
        sc.configureBlocking(false);
        Selector selector = Selector.open();

        SelectionKey key = sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        int index = 0;
        while(true){
            int n = selector.select();
            index++;
            if(n > 0){
                Set<SelectionKey> keys = selector.selectedKeys();
                //Iterator<SelectionKey> it = keys.iterator();

                  //  SelectionKey key2 = it.next();
                    if(key.isReadable()){

                        String str = MyServer.readStrFromChannel(sc);
                        System.out.println("收到消息" + str);
                    }

                    if(key.isWritable()){
                        MyServer.writeStrToClient(sc,"hello"+index);
                        Thread.sleep(1000);
                    }
                    keys.clear();


            }
        }

    }
}
