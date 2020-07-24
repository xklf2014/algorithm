package com.story.algorithm.study3;

import java.util.Arrays;

public class PartitionAndQuickSort {

    //调换位置，如果是同一内存地址则无法使用
    public static void swape(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }

        if (L == R) {
            return L;
        }

        int lessEqual = L - 1;
        int index = L;

        while (index < R) {
            if (arr[index] <= arr[R]) {
                swape(arr, index, ++lessEqual);
            }
            index++;
        }
        swape(arr, ++lessEqual, R);
        return lessEqual;
    }

    public static int[] netherLandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }

        if (L == R) {
            return new int[]{L, R};
        }

        int less = L - 1; //小于区右边界
        int more = R; //大于区左边界
        int index = L;

        //如果2个边界未碰头，则继续循环，直到3个区域全部区分完成
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] > arr[R]) {
                swape(arr, index, --more);
            } else {
                swape(arr, index++, ++less);
            }
        }
        swape(arr, index, R);
        return new int[]{less + 1, more};

    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        int mid = partition(arr, L, R);
        process1(arr, L, mid - 1);
        process1(arr, mid + 1, R);
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process2(arr, 0, arr.length - 1);

    }

    private static void process2(int[] arr, int L, int R) {
        if (L >= R) return;
        int[] equalArea = netherLandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);

    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process3(arr, 0, arr.length - 1);
    }

    public static void process3(int[] arr, int L, int R) {
        if (L >= R) return;
        swape(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherLandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }


    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] res = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return res;
    }

    public static int[] copyArray(int[] arr){
        if (arr == null)  return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i]  = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 ==null && arr2 != null) || (arr1 !=null && arr2 == null))return false;
        if (arr1 ==null && arr2 ==null) return true;
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
        int testTimes = 1;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0 ; i < testTimes;i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);

            quickSort1(arr1);
            quickSort2(arr2);
            quickSort3(arr3);

            if (!isEqual(arr1,arr2) || !isEqual(arr2,arr3)){
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "nice" : "Oops");
    }


/*    public static void main(String[] args) {
        *//*int[] arr = {7, 4, 3, 3, 3, 1};
        quickSort3(arr);
        System.out.println(Arrays.toString(arr));*//*
        //quickSort1(arr);
        //quickSort2(arr);
        //System.out.println(Arrays.toString(arr));

    }*/
}
