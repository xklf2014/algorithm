package com.story.algorithm.selfTest;

import java.util.Arrays;

public class CountSumSortTest {
    public static void main(String[] args) {
        int [] arr = {2,4,2,3,7,1,1,0,0,5,6,9,8,5,7,4,0,9};
        sort(arr);
    }

    private static void sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i =0;i<arr.length;i++){
            count[arr[i]]++;
        }

        System.out.println(Arrays.toString(count));

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i-1];
        }

        System.out.println(Arrays.toString(count));

        for (int i =arr.length-1;i>=0;i--){
            result[--count[arr[i]]] = arr[i];
        }


        System.out.println(Arrays.toString(result));
    }

}
