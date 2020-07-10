package com.story.algorithm.study1;

import java.util.Arrays;


public class Generate {

    static SelectionSort selectionSort = new SelectionSort();

    public static void main(String[] args) {
        int testTimes = 10;
        int maxSize = 10;
        int maxValue =100;
        boolean succeed = true;

        for (int i = 0;i<testTimes;i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = Arrays.copyOf(arr1,arr1.length);
            selectionSort.selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }

        System.out.println( succeed ? "Nice!!!":"Awful!!!");

    }

    private static void printArray(int[] arrays) {
        System.out.println(Arrays.toString(arrays));
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int) ((maxSize+1) * Math.random())];
        for (int i = 0;i<arr.length;i++){
            arr[i] = (int) ((int) ((maxValue + 1) * Math.random()) - maxValue * Math.random());
        }
        return arr;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1.length != arr2.length)
            return false;
        for(int i = 0;i < arr1.length;i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
