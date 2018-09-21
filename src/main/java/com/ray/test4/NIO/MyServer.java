package com.ray.test4.NIO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MyServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        SocketAddress addr = new InetSocketAddress("localhost", 8888);
        ssc.bind(addr);
        ssc.configureBlocking(false);

        Selector selector = Selector.open();
        ssc.register(selector,SelectionKey.OP_ACCEPT);

        while(true){
            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();

            Iterator<SelectionKey> it = keys.iterator();
            while(it.hasNext()){
                SelectionKey key = it.next();

                if(key.isAcceptable()){
                   // SocketChannel sc00 = (SocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    InetSocketAddress address = (InetSocketAddress) sc.getRemoteAddress();
                    String ip = address.getAddress().getHostAddress();
                    int port = address.getPort();

                    sc.configureBlocking(false);

                    sc.register(selector,SelectionKey.OP_READ|SelectionKey.OP_CONNECT|SelectionKey.OP_WRITE);
                    System.out.printf("%s : %d ,连接进来了\r\n" , ip, port);

                }
                if(key.isReadable()){
                    SocketChannel sc00 = (SocketChannel) key.channel();
                    String str = readStrFromChannel(sc00);
                    System.out.println(sc00 + "说" + str);

                }
                if(key.isWritable()){
                    SocketChannel sc00 = (SocketChannel) key.channel();
                    writeStrToClient(sc00,"hi i am server");
                    Thread.sleep(1000);
                    
                }
                if(key.isConnectable()){
                    SocketChannel sc00 = (SocketChannel) key.channel();
                    sc00.finishConnect();
                }
                //删除
                it.remove();
            }


        }



    }

    public static void writeStrToClient(SocketChannel sc00, String str) throws IOException {
        ByteBuffer buf = ByteBuffer.wrap(str.getBytes());
        sc00.write(buf);


    }

    public static String  readStrFromChannel(SocketChannel sc00) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int len = 0;
        while( (len = sc00.read(buf)) != 0){
            baos.write(buf.array(),0,len);
            buf.clear();
        }
        return new String(baos.toByteArray());
    }
}
