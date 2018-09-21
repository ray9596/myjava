package com.ray.test;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class day01Test {
    @Test
    public void printAllChar() {
        int line = 0;
        for (int i = 0x0000; i < 0xffff; i++) {
            System.out.print(i + ":" + (char) i + "\t");
            if (line++ > 20) {
                System.out.println();
            }

        }
    }

    @Test
    public void mynameunicode() throws UnsupportedEncodingException {
        String name = "杨 瑞";
        String[] split = name.split(" ");
        //编码
        for (int i = 0; i < split.length; i++) {
            byte[] name2 = split[i].getBytes("unicode");
            System.out.print(new String(name2) + "\t");
        }

        int name3 = '杨';
        System.out.println(name3);
        System.out.println("\u26472");
    }

    /**
     * 2.定义函数，取出整数内存中的存储形态对应的16进制字符串。
     */
    @Test
    public void inttohex() {
        int num = 65534;
        char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            char c2 = c[(num >> (i * 4)) & 0x0f];
            sb.insert(0, c2);
        }
        System.out.println(sb.toString());
    }

    @Test
    public void inttobin() {
        int num = 43872;
        char[] c = {'0', '1'};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 32; i++) {

            char c2 = c[((num >> i) & 1)];
            sb.insert(0, c2);
        }
        System.out.println(sb);

    }

    @Test
    public void bintoint() {
        String num = "00000000000000001010101101100000";
        byte[] num2 = num.getBytes();
        int total = 0;
        for (int i = 0; i < num2.length; i++) {
            total = (int) ((num2[i] - 48) * Math.pow(2, (num2.length - 1 - i))) + total;
        }
        System.out.println(total);
    }

    @Test
    public void test() {
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * 练习1与2
     * long 存到字节数组中再转会long
     */
    @Test
    public void longtobytearr() {
        long l = 128;
        System.out.println(l);
        byte[] c = new byte[8];
        for (int i = 0; i < 8; i++) {
            c[i] = (byte) ((l >> (i * 8)) & 0xff);
            //System.out.println(c[i]);
        }
        //charrarrtolong(c);
        long l2 = 0;
        for (int i = 0; i < 8; i++) {
/*            for (int j = 0; j < 8; j++) {
                l2 = l2 + (long) ((((c[i] >> j) & 1)) * Math.pow(2, (j + i * 8)));
            }*/
            l2 = l2 | ((c[i] & 0xff )  << (8 * i) );
        }
        System.out.println(l2);


    }

    @Test
    public void charrarrtolong() {

    }

    /**
     * 有5亿整数，去重,计算不同数的个数，内存只有300mb
     * 316065365    316057313
     */
    @Test
    public void unrepetition() throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random r = new Random();
        byte[] byt2 = new byte[1024 * 1024 * 300];
        for (int i = 0; i < 500000000; i++) {
            int ii = (r.nextInt(500000000));

            byt2[ii / 8] = (byte) ((byte) Math.pow(2, (ii % 8)) | byt2[ii / 8]);
            //byt2[ii / 8] = (byte) ((byte) Math.pow(2, (ii % 8)) | byt2[ii / 8]);
        }

        int count = 0;
        for (int i = 0; i < byt2.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((byt2[i] >> j & 1) == 1) {
                    count += 1;
                }
            }
        }
        System.out.println(count);


    }

    //文本就用字节流
    @Test
    public void readfile() throws IOException {
        FileInputStream fis = new FileInputStream("G:\\bigdata\\day01\\200.txt");
        byte[] byt = new byte[10];

        int read = fis.read(byt);
        System.out.println(new String(byt, "unicode"));
        fis.close();
    }

    @Test
    public void readfile2() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("G:\\bigdata\\day01\\200.txt"), "unicode");
        char[] cha = new char[1024];
        int len = 0;
        while ((isr.read(cha)) != -1) {
            System.out.println(cha);
        }
    }

    /**
     * 练习4
     * 通过程序创建文本文件，内容是abc，采用uncode码，文件大小是10字节。
     *
     * @throws IOException
     */
    @Test
    public void writefile() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("G:\\bigdata\\day01\\200w.txt"));
        char[] c = { 'a', 'b', 'c'};
        System.out.println(c[0]);
        System.out.println(c[1]);
        System.out.println(c[2]);
        osw.write(c);

        osw.close();

    }


    @Test
    public void unzipfile() throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream("G:\\bigdata\\day01\\100.zip"));
        ZipEntry entry = null;
        while ((entry = zis.getNextEntry()) != null) {
            String name = entry.getName();
            System.out.println(name);
            int len = 0;
            byte[] byt = new byte[1024];
            while ((len = zis.read(byt)) != -1) {
                //FileInputStream fis = new FileInputStream("");
                System.out.print(new String(byt));
            }
        }

        zis.closeEntry();

    }

    /*
        练习5 将byte变成无符号的整数（0~255 ， 正数不变）
     */
    @Test
    public void bytetounsignednum() {
        byte b = -128;

        int b1 = 0;
        System.out.println(b);
        if (b < 0) {
            b1 =  (b & 0xff);
        }
        System.out.println(b1);
    }

    @Test
    public void serializeObject() throws IOException {
        Consumner c = new Consumner();
        c.setId(001);
        c.setName("tom");

        Consumner c2 = new Consumner();
        c2.setId(002);
        c2.setName("tom2");

        Order o = new Order();
        o.setOid(101);
        o.setOname("list1");

        Item it = new Item();
        it.setId(201);
        it.setIname("abc");


        c.getOlist().add(o);
        c2.getOlist().add(o);

        o.getIlist().add(it);


        //浅度复制
        Consumner c3 = new Consumner();
        c3.setId(c.getId());
        c3.setName(c.getName());
        c3.setOlist(c.getOlist());

        //深度复制
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G:\\bigdata\\day01\\object.txt"));
        oos.writeObject(c);
        oos.close();


    }

    @Test
    public void unserializeObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G:\\bigdata\\day01\\object.txt"));
        Object o = ois.readObject();
        Consumner cc = (Consumner) o;
        System.out.println(cc.getId() + "\t" + cc.getName());
    }
    /*
    产生一个5亿个随机数的文件
     */

    @Test
    public void getfile() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("G:\\bigdata\\day01\\500.txt"));
        //FileWriter fw = new FileWriter("G:\\bigdata\\day01\\500.txt");
        Random r = new Random();
        for (int i = 0; i < 500000000; i++) {

            osw.write(r.nextInt(500000000)+ "\n");

        }
        osw.close();
    }

    @Test
    public void unrepetition2() throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        InputStreamReader isr = new InputStreamReader(new FileInputStream("G:\\bigdata\\day01\\500.txt"));
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        byte[] byt2 = new byte[1024 * 1024 * 300];
        while ((line = br.readLine()) != null && line.length() >= 1) {
                int i = Integer.valueOf(line);

                   // System.out.println(i);


                byt2[i / 8] = (byte) ((byte) Math.pow(2, (i % 8)) | byt2[i / 8]);
        }
        int count = 0;
        for (int i = 0; i < byt2.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((byt2[i] >> j & 1) == 1) {
                    count += 1;
                }
            }
        }
        System.out.println(count);


    }

}
