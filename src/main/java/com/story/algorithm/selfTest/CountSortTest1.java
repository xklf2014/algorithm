package com.story.algorithm.selfTest;

public class CountSortTest1 {
    public static void main(String[] args) {
        int [] arr = {100,120,120,102,103,108,145,111,116,117,100};
        
        int [] tmp = new int[50];
        int [] newArr = new int[arr.length];

        for (int i=0;i<arr.length;i++){
            tmp[arr[i]-100]++;
        }

        for (int i=0, j=0;i < tmp.length;i++){
            while (tmp[i]-- > 0) newArr[j++] = i+100;
        }

        printArray(newArr);

    }

    static void printArray(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
}
