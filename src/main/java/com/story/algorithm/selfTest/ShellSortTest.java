package com.story.algorithm.selfTest;

public class ShellSortTest {
    public static void main(String[] args) {
        int[] arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};

        for(int h =4;h>0;h /=2){
            for (int i = h; i< arr.length;i++){
                for (int j = i;j>h-1 ;j-=h){
                    if (arr[j]<arr[j-h])
                        swape(arr,j,j-h);
                }
            }
        }



        printArray(arr);
    }


    static void sort(int[] arr){
        long startTime = System.currentTimeMillis();
        for(int h =4;h>0;h /=2){
            for (int i = h; i< arr.length;i++){
                for (int j = i;j>h-1 ;j-=h){
                    if (arr[j]<arr[j-h])
                        swape(arr,j,j-h);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("shell以4为步长程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
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
