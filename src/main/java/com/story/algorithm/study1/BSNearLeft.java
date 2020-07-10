package com.story.algorithm.study1;

public class BSNearLeft {
    public static int nearestIndex(int[] arr,int value){
        int L = 0;
        int R = arr.length -1;
        int index = -1;
        while (L<=R){
            int mid  = L + ((R-L) >> 1);
            if (arr[mid] >= value){
                index = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static int test(int[] arr, int value){
        for (int i = 0;i<arr.length;i++){
            if (arr[i] >= value){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,3,3,3,4,5,6,7,8,9};

        System.out.println(test(arr, 3));
        System.out.println("---------------------");
        System.out.println(nearestIndex(arr, 3));
    }
}
