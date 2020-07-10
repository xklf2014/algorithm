package com.story.algorithm.selfTest;

public class SelectionSortTest1 {
    public static void main(String[] args) {
        int[] arrays = {1,3,5,7,9,2,4,6,8};

        for (int i = 0; i < arrays.length / 2; i++) {
            int minPos = i;
            int maxPos = arrays.length -i -1;

            for (int j = i+1;j<arrays.length;j++)
                minPos = arrays[j] < arrays[minPos] ? j : minPos;

            for (int j = arrays.length -i -1;j>0;j--)
                maxPos = arrays[j] > arrays[maxPos] ? j : maxPos;

            swape(arrays,i,minPos);
            swape(arrays,arrays.length -i -1,maxPos);
        }

        for (int i = 0 ;i < arrays.length;i++){
            System.out.println(arrays[i]);
        }


    }

    static void swape(int[] arrays,int i,int j){
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
}
