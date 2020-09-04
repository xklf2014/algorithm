package com.story.algorithm.study9;

import java.util.PriorityQueue;

public class LessMoneySplitGold {
    public static int lessMoney1(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        return process(arr, 0);
    }

    private static int process(int[] arr, int pre) {
        if (arr.length == 1) return pre;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ans = Math.min(ans, process(copyAndMergeTwo(arr, i, j), pre + arr[i] + arr[j]));
            }
        }

        return ans;
    }

    private static int[] copyAndMergeTwo(int[] arr, int i, int j) {
        int[] ans = new int[arr.length - 1];
        int ansi = 0;
        for (int arri = 0; arri < arr.length; arri++) {
            if (arri != i && arri != j) {
                ans[ansi++] = arr[arri];
            }
        }
        ans[ansi] = arr[i] + arr[j];
        return ans;
    }

    public static int lessMoney2(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static int[] generateRandom(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue+1));
        }
        return arr;
    }

    public static void main(String[] args) {
        int maxSize = 6;
        int maxValue = 100;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandom(maxSize, maxValue);
            System.out.println("lessmoney1 "+lessMoney1(arr));
            System.out.println("lessmoney2 "+lessMoney2(arr));
            if (lessMoney1(arr)!= lessMoney2(arr)){
                System.out.println("Oops");
            }
        }
        System.out.println("test finished");
    }
}
