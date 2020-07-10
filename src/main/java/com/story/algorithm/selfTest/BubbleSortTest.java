package com.story.algorithm.selfTest;

public class BubbleSortTest {
    public static void main(String[] args) {

        int [] arrays = {1,3,5,7,2,4,6,8,9};

        sort(arrays);

        printArray(arrays);
    }

    static void printArray(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    static void sort(int[] arrays){
        boolean flag;
        for (int i = 0; i < arrays.length; i++) {
            flag = false;
            for (int j = 1;j<arrays.length - i- 1;j++){
                if (arrays[j-1]>arrays[j]){
                    int tmp = arrays[j];
                    arrays[j] = arrays[j-1];
                    arrays[j-1] = tmp;
                    flag = true;
                }

            }

            if (!flag){
                return;
            }
        }


    }
}
