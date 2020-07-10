package com.story.algorithm.study1;

public class BSExist {

    public static boolean exist(int[] sortArr,int num){


        if (sortArr == null || sortArr.length < 2) return false;
        int L = 0;
        int R = sortArr.length - 1;
        int mid = 0;
        while ( L < R ){
            mid = L + ((R-L) >> 1); // 等同于 L + （R-L）/2  ==  (R+L)/2   只有在数值极大的时候可能会出现越界
            if (sortArr[mid] == num){
                return true;
            }else if (sortArr[mid] > num){
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return sortArr[L] == num;
    }
}
