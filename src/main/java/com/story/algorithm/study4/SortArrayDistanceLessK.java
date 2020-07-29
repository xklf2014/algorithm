package com.story.algorithm.study4;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数组0 - n
 * 步长k
 * 则0-k之间必有最小值
 * 1 - (k+1)之间有次小值
 * 2 - （k + 2）之间有倒数第三小值
 * 剩余数量小于k，则一定为小跟堆，依次弹出
 * */
public class SortArrayDistanceLessK {

    public static void sortedArrDistanceLessK(int[] arr,int k){
        if (k == 0 ) return;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;

        //将k位的数字放进小跟堆heap
        for (;index <= Math.min(arr.length -1 ,k -1);index++){
            heap.add(arr[index]);
        }

        int i = 0;
        //弹出最小值，将k+1位放进小跟堆,循环迭代直到所有arr放入堆中
        for (; index < arr.length; i++,index++){
            heap.add(arr[index]);
            arr[i] =heap.poll();
        }

        //将堆中剩余部分依次弹出
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }

    }

    public static void compartor(int[] arr){
        Arrays.sort(arr);
    }

    public static int[] randomArrayNoMoveMoreK(int maxSize,int maxValue,int k){
        int[] arr = new int[(int)((maxSize+1)*Math.random())];
        for (int i =0;i<arr.length;i++){
            arr[i] = (int)((1+maxValue) * Math.random()) - (int)(maxValue * Math.random());
        }
        Arrays.sort(arr);
        boolean[] isSwap = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = Math.min(i + (int)(Math.random() * (k + 1)),arr.length - 1);
            if (!isSwap[i] && isSwap[j]){
                isSwap[i] = true;
                isSwap[j] = true;
                int tmp =arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return arr;

    }

    public static int[] copyArray(int[] arr){
        if (arr == null) return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 ==null && arr2 != null) || (arr1 != null && arr2 ==null)) return false;
        if (arr1 ==null && arr2 == null) return true;
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }



    public static void main(String[] args) {
        System.out.println("test begin");
        int maxSize = 10;
        int maxValue = 100;
        int testTimes = 1;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int k =(int)(Math.random() * maxSize) + 1;
            int[] arr = randomArrayNoMoveMoreK(maxSize,maxValue,k);
            int[] arr1 =copyArray(arr);
            int[] arr2 =copyArray(arr);
            sortedArrDistanceLessK(arr1,k);
            compartor(arr2);

            if (!isEqual(arr1,arr2)){
                succeed = false;
                System.out.println("k" + k);
                printArray(arr);
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Oops");
        System.out.println("test end");


        /*int[] arr = {3,4,5,2,1};
        sortedArrDistanceLessK(arr,3);
        System.out.println(Arrays.toString(arr));*/
    }
}
