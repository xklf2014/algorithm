package com.story.algorithm.study1;

public class LocalSmallest {
    public static int getLessIndex(int[] arr){
            if (arr == null || arr.length == 0) return -1;
            if (arr.length == 1 || arr[0] < arr[1]) return 0;
            if (arr[arr.length-1] < arr[arr.length - 2]) return arr.length -1;

            int left = 0;
            int right = arr.length - 2;
            int mid = 0;
            while (left < right){
                mid = left + ((right - left) >> 1);
                if (arr[mid]>arr[mid -1]){
                    right = mid - 1;
                }else if(arr[mid] > arr[mid+1]){
                    left = mid + 1;
                }else{
                    return mid;
                }
            }
            return left;
    }

    public static void main(String[] args) {
        int[] arr = {6,5,4,3,1,2,7};
        System.out.println(getLessIndex(arr));

    }
}
