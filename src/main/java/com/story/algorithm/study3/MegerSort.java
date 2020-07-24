package com.story.algorithm.study3;

import java.util.Arrays;

public class MegerSort {

    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        //求出中点位置
        int mid = L + ((R - L) >> 1);
        //递归左侧部分,拆分城最小粒度
        process1(arr, L, mid);
        //递归右侧部分,拆分城最小粒度
        process1(arr, mid + 1, R);
        merge(arr, L, mid, R);

    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        //左右2组进行pk，取出小的数，值到任意一方越界
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //满足p1或者p2任意一个条件越界后，将剩余部分天剑到help[]，完成排序
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while ((p2 <= R)) {
            help[i++] = arr[p2++];
        }
        //将排好序的help数组刷回原数组
        for (i = 0; i < help.length; i++) {
            arr[i + L] = help[i];
        }
    }


    public static void mergerSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;

        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int M = L + mergeSize - 1;

                if (M >= N) {
                    break;
                }

                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }


    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //生成最大size为maxSize的随机长度数组
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];

        //给数组填充范围为正负maxValue范围的数值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) -(int)((maxValue) * Math.random());
        }
        return arr;
    }

    //拷贝数组
    public static int[] copyArr(int[] arr){
        if (arr ==null ){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0;i<arr.length;i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        //任意一个为null，另外一个不为null，返回false
        if ((arr1==null && arr2 !=null ) || (arr1 != null && arr2 == null)){
            return false;
        }

        //都是null返回true
        if (arr1 == null && arr2 == null){
            return true;
        }
        //长度不等，返回false
        if (arr1.length != arr2.length){
            return false;
        }
        //任意数值不等，返回false
        for (int i = 0;i<arr1.length;i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void printArr(int[] arr){
        if (arr == null){
            return;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int timeTimes = 10;
        int maxSize =100;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0;i< timeTimes;i++){
            int[] arr1 =generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArr(arr1);

            mergeSort1(arr1);
            mergerSort2(arr2);
            if (!isEqual(arr1,arr2)){
                succeed  = false;
                printArr(arr1);
                printArr(arr2);
                break;
            }

        }
        System.out.println( succeed ? "nice" : "Oops");
    }
}
