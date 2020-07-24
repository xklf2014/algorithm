package com.story.algorithm.study3;


import java.util.Arrays;

public class SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    //arr[L..R]排好序并且算出小和，merger时计算小和，累加
    //左右两边小和计算好，最终在merge一次求出全部小和累加值进行返回
    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);

    }

    private static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int result = 0;

        while (p1 <= m && p2 <= r) {
            result += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= m) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[i + l] = help[i];
        }

        return result;
    }

    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }

        return res;
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[ (int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxSize + 1) * Math.random()) - (int)((maxSize) * Math.random());
        }
        return arr;
    }

    public static int[] copy(int[] arr){
        if (arr ==null){
            return null;
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }

        return res;

    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 == null & arr2 != null) || (arr1 != null & arr2 == null)){
            return false;
        }

        if (arr1 == null && arr2 == null){
            return true;
        }

        if (arr1.length != arr2.length){
            return false;
        }

        for (int i = 0 ;i<arr1.length;i++){
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
//        int[] arr = {1, 1, 1, 2, 3};
//        System.out.println(smallSum(arr));
//        System.out.println(Arrays.toString(arr));
//        System.out.println(comparator(arr));


        int testTimes = 100;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;

        for (int i =0;i<testTimes;i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copy(arr1);

            if (smallSum(arr1)!=comparator(arr2)){
                succeed = false;
                printArr(arr1);
                System.out.println(smallSum(arr1));
                printArr(arr2);
                System.out.println(comparator(arr2));
                break;
            }
        }

        System.out.println(succeed?"well done!" : "Oops!!");
    }
}
