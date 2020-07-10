package com.story.algorithm.study1;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9,7,5,3,1,2,4,6,8,10,20};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2) return;

        for (int i = arr.length -1 ;i >0;i--){
            for (int j = 0;j<i;j++){
                if (arr[j] > arr[j+1]) swap(arr,j,j+1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
