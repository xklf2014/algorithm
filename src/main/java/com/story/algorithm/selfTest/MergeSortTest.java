package com.story.algorithm.selfTest;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,2,4,6,8};
        int[] tmp = new int[arr.length];

        int mid = arr.length >> 1;
        int i = 0;
        int j = mid + 1;
        int k = 0;

        while ( i <= mid && j < arr.length){
            tmp[k++] = arr[i]<=arr[j] ? arr[i++] : arr[j++];
        /*    if (arr[i]<=arr[j]){
                tmp[k++] = arr[i++];
            }else{
                tmp[k++] = arr[j++];
            }*/
        }


        while(i<=mid) tmp[k++] = arr[i++];
        while(j<arr.length) tmp[k++] = arr[j++];

        printArray(tmp);
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
