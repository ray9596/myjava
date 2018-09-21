package com;

public class test {
    public static void main(String[] args) {
        String str1 = "001.2.3a";
        String str2 = "1.2.4b";
        String max = maxversion(str1,str2);
        System.out.println(max);
    }
    //比较版本号大小
    private static String maxversion(String str1, String str2) {
        String[] arr1 = str1.split(".");
        String[] arr2 = str2.split(".");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = len1 >= len2 ? len2 : len1;
        for(int i = 0 ; i<len;i++){
            int n = maxstr(arr1[i],arr2[i]);
            if(n == 0) {
                continue;
            }else if( n == 1){
                return str1;
            }else if (n == -1){
                return str2;
            }
        }
        return len1 > len2 ? str1: str2;
    }
    //按照 1>A>a这种顺序排序
    private static int maxstr(String s1, String s2) {
        byte[] byt1 = s1.getBytes();
        byte[] byt2 = s2.getBytes();
        //如果开头为000001 ，按1算
        int len1 = truelen(byt1);
        int len2 = truelen(byt2);
        if(len1 > len2)
            return 1;
        else {
            if(len1 < len2){
                return -1;
            }
            else {
                for(int i = 0 ;i < len1 ; i++){
                    byt1[i] = (byt1[i] >= 65) ? (byte) -byt1[i] : byt1[i];
                    byt2[i] = (byt2[i] >= 65) ? (byte) -byt2[i] : byt1[i];
                    if(byt1[i] > byt2[i]){
                        return 1;
                    }else {
                        if(-byt1[i] < -byt2[i])
                            return -1;
                    }
                }
            }
        }
        return 0;
    }
    //求真实的长度
    private static int truelen(byte[] byt) {
        int i = 0;
        int len = 0;
        while(byt[i] == 0){
            len = byt.length-1;
            i++;
        }
        return len;
    }
}
