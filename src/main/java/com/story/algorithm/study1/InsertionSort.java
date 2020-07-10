package com.story.algorithm.study1;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,8,6,4,2,0,10};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2) return;

        for (int i =1 ;i<arr.length;i++){
            for (int j= i -1 ; j >=0 && arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
