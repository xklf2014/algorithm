package com.story.algorithm.study5;

import java.util.Arrays;

public class CountSort {

    // only for 0-200 value
    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }

    }

    public static void compartor(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] res = new int[((int) (Math.random() * (maxSize + 1)))];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * (maxValue + 1));
        }
        return res;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))) return false;
        if ((arr1 == null) && (arr2 == null)) return true;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int maxValue = 1000;
        int testTimes = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize,maxValue);
            int[] arr1 = copyArray(arr);

            countSort(arr);
            compartor(arr1);

            if (!isEqual(arr,arr1)){
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "nice" : "Oops");
    }
}
