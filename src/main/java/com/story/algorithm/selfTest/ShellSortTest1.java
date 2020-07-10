package com.story.algorithm.selfTest;

import java.sql.Timestamp;
import java.util.Date;

public class ShellSortTest1 {
    public static void main(String[] args) {
        int[] arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        //knuth序列
        int h = 1;
        while(h <= arr.length / 3){
            h = h * 3 + 1;
        }

        for(int step = h;step>0;step = (step - 1) / 3){
            for (int i = step; i< arr.length;i++){
                for (int j = i;j>step-1 ;j-=step){
                    if (arr[j]<arr[j-step])
                        swape(arr,j,j-step);
                }
            }
        }



        printArray(arr);
    }

    static void sort(int[] arr){
        long startTime = System.currentTimeMillis();

        //knuth序列
        int h = 1;
        while(h <= arr.length / 3){
            h = h * 3 + 1;
        }

        for(int step = h;step>0;step = (step - 1) / 3){
            for (int i = step; i< arr.length;i++){
                for (int j = i;j>step-1 ;j-=step){
                    if (arr[j]<arr[j-step])
                        swape(arr,j,j-step);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Knuth序列shell程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    static void swape(int[] arrays,int i,int j){
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    static void printArray(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
}
