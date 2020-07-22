package com.story.algorithm.study2;

public class GetMax {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 6, 7,8, 11};
        int max = getMax(arr);
        System.out.println(max);
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    //从begin到end范围上取最大值
    public static int process(int[] arr, int begin, int end) {
        if (begin == end) {
            return arr[begin];
        }

        int middle = begin + ((end - begin) >> 1);
        int leftMax = process(arr, begin, middle);
        int rightMax = process(arr, middle + 1, end);

        return Math.max(leftMax, rightMax);

    }
}
