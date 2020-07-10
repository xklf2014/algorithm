package com.story.algorithm.selfTest;

import java.util.Arrays;

public class RadixSortTest {
    public static void main(String[] args) {
        int [] arr = {421,240,115,532,305,430,12422};
        int max = findMax(arr);
        int[] result = sort(arr,max);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sort(int[] arr,int max) {
        long startTime = System.currentTimeMillis();
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i=0;i<max;i++) {
            int devision = (int) Math.pow(10, i);
            //System.out.println(devision);

            for (int j = 0; j < arr.length; j++) {
                int num = arr[j] / devision % 10;
                //System.out.println(num);

                count[num]++;
            }
            //System.out.println(Arrays.toString(count));

            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m - 1];
            }
            //System.out.println("累加数组" + Arrays.toString(count));
            String unit = "";
            switch (devision){
                case 1:
                      unit = "个";
                      break;
                case 10:
                    unit = "十";
                    break;
                case 100:
                    unit = "百";
                    break;
            }
            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / devision % 10;
                //System.out.println("累加数组" + Arrays.toString(count));
                //System.out.println(num);

                result[--count[num]] = arr[n];
                //System.out.println("将"+unit+"位进行排序，第"+(arr.length-1-n)+"次结果->"+Arrays.toString(result));
                //System.out.println("-----------------------------------");
            }
            //System.out.println("各位排序" + Arrays.toString(result));

            //更新基础数组
            System.arraycopy(result,0,arr,0,arr.length);
            //清空累计数组
            Arrays.fill(count,0);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("基数排序程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        return result;

    }


    static int findMax(int[] arr){
        int max = arr[0];
        int n = 1;
        for (int i = 1;i<arr.length;i++){
            max = arr[i] > max ? arr[i] : max;
        }

        while ((max /= 10) > 0) n++;
        return n;
    }
}
