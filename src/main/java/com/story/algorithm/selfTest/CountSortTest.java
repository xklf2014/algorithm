package com.story.algorithm.selfTest;

public class CountSortTest {
    public static void main(String[] args) {
        int [] arr = {0,2,2,2,3,8,5,1,6,7,0};

        int [] tmp = new int[arr.length];
        int [] newArr = new int[arr.length];

        for (int i=0;i<arr.length;i++){
            tmp[arr[i]]++;
        }

        for (int i=0, j=0;i < tmp.length;i++){
            while (tmp[i]-- > 0) newArr[j++] = i;
        }

        printArray(newArr);

    }

    static void printArray(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
}
