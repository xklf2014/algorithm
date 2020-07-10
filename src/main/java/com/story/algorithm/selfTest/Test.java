package com.story.algorithm.selfTest;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //testTime是测试次数
        int testTime = 10;
        int size = 100000;
        int value = 100;
        boolean succeed = true;
        for(int i = 0;i < testTime;i++) {
            int[] arr1 = generateRandomArray(size, value);
            //拷贝数组，数组new出来的就是在栈中不同的空间中存放，内容相同
            //copyArray(int[] arr)是自己实现的拷贝方法

            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);

            //ShellSortTest.sort(arr2);
            //ShellSortTest1.sort(arr3);
            QuickSortTest.run(arr2,0,arr2.length-1);
            //MergeSortTest1.runSort(arr3,0,arr3.length-1);
            int max = RadixSortTest.findMax(arr3);
            RadixSortTest.sort(arr3,max);

            if(!isEqual(arr3, arr2)) {
                succeed = false;
                //打印出错的数组，printArray是自习实现的打印的方法
                //printArray(arr3);
                break;
            }
        }
        //打印要测的部分是否正确
        System.out.println(succeed ? "succeed!" : "false..");
    }

    public static int[] generateRandomArray(int size, int value) {
        //产生的数组长度是[0, size]
        int[] arr = new int[(int) ((size + 1) * Math.random())];

        //产生的数组中的数的范围是-value ~ value
        for(int i = 0;i < arr.length;i++) {
            arr[i] = (int) ((value + 1) * Math.random());
                   // - (int) (value * Math.random()));
        }
        return arr;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1.length != arr2.length)
            return false;
        for(int i = 0;i < arr1.length;i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
