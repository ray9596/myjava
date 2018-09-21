package com.ray.test2;

import org.junit.Test;

import java.util.TreeMap;

public class sorttest {
    //冒泡排序时间复杂度n^2
    @Test
    public void bubblesort() {
        int[] arr = {67, 4, 12, 85, 11, 1, 45, 87, 98};
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i + 1] < arr[i]) {
                    int num = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = num;
                }
                // arr[i] = arr[i + 1] > arr[i] ? arr[i] : arr[i + 1];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }


    //二分查找时间复杂度 log2 N
    @Test
    public void bisearch() {
        int num = 67;
        int[] arr = {1,4,11,12,45,67,85,87,98};
        int low = 1;
        int high = arr.length;
        while( low <=high ){
            int mid = (low+high) / 2;
            if (arr[mid] == num) {
                System.out.println(mid);
                break;
            }else if (arr[mid] < num){
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }

    }

    //时间复杂度 n^2
    @Test
    public void for99z() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "x" + j + "=" + j * i + "\t");
            }
            System.out.println();
        }
    }

    //两个n阶方阵的时间复杂度  n^3
    @Test
    public void matrie2n() {
        int[][] n1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] n2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] n3 = new int[3][3];
        for (int k = 0 ; k < n3.length;k++) {
            for (int i = 0; i < n1.length; i++) {
                int temp = 0;
                for (int j = 0; j < n2[i].length; j++) {
                    temp += n1[k][j] * n2[j][i];
                }
                n3[k][i] = temp;
            }
        }
        for (int i = 0; i < n3.length; i++) {
            for (int j = 0; j < n3[i].length; j++) {
                System.out.print(n3[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //红黑树一次存放5个数 1 2 3 4 5 给出 树结构
    @Test
    public void treemaptest() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.put(8, 8);
        System.out.println(map.size());
        System.out.println(map);
    }

}
