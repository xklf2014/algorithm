package com.story.algorithm.selfTest;

public class InsertionSortTest1 {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,0,1,9,7,5,3,1};

        for (int i = 1; i< arr.length;i++){
            int temp = arr[i];
            int minIdx = 0;
            for (int j = i;j>0;j--){
                if (temp < arr[j - 1]){
                    arr[j] = arr[j-1];
                }else{
                    minIdx = j;
                    break;
                }
            }
            arr[minIdx] = temp;

        }

        printArray(arr);
    }

    static void swape(int[] arrays,int i,int j){
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    static void printArray(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
}
