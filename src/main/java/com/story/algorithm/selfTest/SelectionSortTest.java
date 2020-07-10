package com.story.algorithm.selfTest;

public class SelectionSortTest {

    public static void main(String[] args) {
        int[] arrays = {9, 7, 5, 3, 1, 8, 6, 4, 2};
        boolean flag = true;

        for (int i = 0; i < arrays.length - 1; i++) {
            int minPos = i;
            for (int j = i+1;j<arrays.length;j++){
                /*if (arrays[j]<arrays[minPos])
                    minPos = j;*/
                minPos = arrays[j] < arrays[minPos] ? j : minPos;
            }

            swape(arrays,i,minPos);
        }

        printArray(arrays);
    /*    for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }*/
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
