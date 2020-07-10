package com.story.algorithm.study1;

public class EvenTimesOddTimes {

    //数组中仅有1个数字为奇数个数
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for (int i = 0 ;i < arr.length;i++){
            eor ^= arr[i];
        }
        System.out.println(eor);

    }

    //数组中仅有两个数字为奇数个数
    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for (int i = 0 ;i < arr.length;i++){
            eor ^= arr[i];
        }
        //此时得到的eor为2个不同数的异或，即a^b
        //既然为2个不同的数字，则必有a^b != 0
        //则eor上必有一位为1,此时获取eor上最右侧的1
        int rightOne = eor & (~eor + 1);

        int onlyONe = 0; //eor'
        for (int i = 0 ;i < arr.length;i++){
            //通过此循环得出a^b其中的一个数字
            if ((arr[i] & rightOne) != 0){
                onlyONe ^= arr[i];
            }
        }
        //打印其中一个数字，然后通过异或eor取出另外一个数字
        System.out.println(onlyONe + " " + (onlyONe ^ eor));
    }

    public static int getBitCount(int N){
        int original = N;
        int count = 0;
        while (N !=0){
            //样例： N = 7
            //2进制数为    0111
            //最右侧的1位  0001
            int rightOne = N & (~N + 1);
            count++;
            // N ^ right = 0111 ^ 0001 等于 0110，变相等同于清空最后一位1
            N ^= rightOne;

        }
        System.out.println(original+"的二进制数为"+count);
        return count;
    }


    public static void main(String[] args) {
        System.out.println("【数组中个数为奇数的数字】");
        int [] arr = {1,1,2,2,1,1,3,3,3,4,4,6,5,6,5};
        printOddTimesNum1(arr);
        System.out.println("【数组中2个位数为奇数的数字】");
        int[] arr1 = {1,1,1,1,1,2,2,3,3,5,5,4,4,4};
        printOddTimesNum2(arr1);
        System.out.println("【二进制数1点个数】");
        getBitCount(13);

    }
}
