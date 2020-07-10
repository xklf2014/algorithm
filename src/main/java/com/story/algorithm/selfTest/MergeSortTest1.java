package com.story.algorithm.selfTest;

public class MergeSortTest1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,2,4,6};

        //printArray(merge(arr,1,4,5));
        runSort(arr,0,6);
        printArray(arr);
    }

    static void runSort(int[] arr,int left,int right){
        long startTime = System.currentTimeMillis();
        sort(arr,left,right);
        long endTime = System.currentTimeMillis();
        System.out.println("归并排序程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    static void sort(int[] arr,int left ,int right){

        if (left==right) return;
        int mid = left + ((right-left) >> 1);
        sort(arr,left,mid);
        sort(arr,mid+1,right);

        merge(arr,left,mid+1,right);

    }

    static void merge(int[] arr,int start,int mid,int end){
        int[] tmp = new int[end-start+1];
        int middle = mid - 1;
        int i = start;
        int j = mid;
        int k = 0;

        while ( i <= middle && j <= end){
            tmp[k++] = arr[i]<=arr[j] ? arr[i++] : arr[j++];
        }


        while(i<=middle) tmp[k++] = arr[i++];
        while(j<=end) tmp[k++] = arr[j++];

        for (int m = 0;m<tmp.length;m++) arr[start+m] = tmp[m];
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
