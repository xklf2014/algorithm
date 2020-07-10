package com.story.algorithm.study1;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9,7,5,3,1,2,4,6,8,10};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){
        if (arr==null || arr.length < 2) return;

        for (int i=0;i <arr.length -1 ;i++){
            int minIdx = i;
            for (int j = i + 1;j<=arr.length -1 ;j++){
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }
            swap(arr,minIdx,i);
        }
    }

    private static void swap(int[] arr, int minIdx, int i) {
        int tmp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = tmp;
    }
}
