package com.story.algorithm.selfTest;

public class QuickSortTest {
    public static void main(String[] args) {
        //int[] arr = {1,4,6,9,10,2,3,5,8,7,0};
        int[] arr = {7,3,2,10,8,1,9,5,4,6};
        sort(arr,0,arr.length-1);

        //printArray(arr);

    }

    static void run(int[] arr,int begin,int end){
        long startTime = System.currentTimeMillis();
        sort(arr,begin,end);
        long endTime = System.currentTimeMillis();
        System.out.println("快排程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

    static void sort(int[] arr,int begin,int end){
        if (begin>=end) return;
        int mid = partition(arr,begin,end);
        sort(arr,begin,mid-1);
        sort(arr,mid+1,end);

    }

    static int partition(int[] arr,int begin,int end){
        int left = begin;
        int right = end - 1;
        int temp = arr[end];
        while (left<=right){
//            if (arr[left] > arr[temp] && arr[right] < arr[temp]){
//                swape(arr,left++,right--);
//            }
//            if (left<=right && arr[left] <= arr[temp])
//                left++;
//            if (left<=right && arr[right] > arr[temp])
//                right--;
            while (left<=right && arr[left] <= temp) left++;
            while (left<=right && arr[right] > temp) right--;
            if (left<right) swape(arr,left,right);
        }
//        System.out.println();
//        System.out.println("交换前->");
//        printArray(arr);
//        System.out.println();
        //if (arr[left] > arr[end])  swape(arr,left,end);
        swape(arr,left,end);
//        System.out.println("交换后->");
//        printArray(arr);
        return left;
    }

    static void swape(int[] arrays,int i,int j){
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    static void printArray(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]+"\t");
        }
    }
}
