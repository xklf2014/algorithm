package com.story.algorithm.study5;

import java.util.Arrays;

public class RadixSort {

    // only for no-negative value
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    private static void radixSort(int[] arr, int L, int R, int digit) {
        // 0...9
        final int radix = 10;
        int i = 0, j = 0;
        //准备出辅助数组
        int[] help = new int[R - L + 1];
        //根据原数组求出计数数组
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }

            //通过计数数组求出累加数组
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }

            for (i = L, j = 0; i <= R; ) {
                arr[i++] = help[j++];
            }
        }


    }

    //取出对应位置的数字（个、十、百...）
    private static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    //计算最大数值位数
    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void compartor(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] res = new int[(int) ((maxSize + 1) * Math.random())];
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
        if ((arr1 != null && arr2 == null) || (arr1 == null && arr2 != null)) return false;
        if ((arr1 == null && arr2 == null)) return true;
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
//        int maxSize = 100;
//        int maxValue = 1000;
//        int testTimes = 1000;
//        boolean succeed = true;
//
//        for (int i = 0; i < testTimes; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//
//            radixSort(arr1);
//            compartor(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                break;
//            }
//        }
//
//        System.out.println(succeed ? "nice" : "Oops");
        int[] arr = {23,54,103,202,5};
        radixSort(arr);
    }
}
