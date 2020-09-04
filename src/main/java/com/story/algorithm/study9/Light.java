package com.story.algorithm.study9;

import java.util.HashSet;

public class Light {
    public static int minLight1(String road) {
        if (road == null || road.length() == 0) return 0;

        return process(road.toCharArray(), 0, new HashSet<>());
    }

    /*
     *   str[index...]置位，自由选择是否放灯
     *   已经决定哪些放了灯的位置放到lights里
     *   要选出照亮所有.的方案，并在这些所有方案中选出最少需要几个灯
     * */
    private static int process(char[] str, int index, HashSet<Object> lights) {
        if (str.length == index) { //结束的条件
            for (int i = 0; i < str.length; i++) {
                if (str[i] != 'X') {
                    if (!lights.contains(i - 1)
                            && !lights.contains(i)
                            && !lights.contains(i + 1)
                    ) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        } else {
            int no = process(str, index + 1, lights);
            int yes = Integer.MAX_VALUE;
            if (str[index] == '.') {
                lights.add(index);
                yes = process(str, index + 1, lights);
                lights.remove(index);
            }
            return Math.min(no, yes);
        }
    }

    public static int minLight2(String road) {
        char[] str = road.toCharArray();
        int index = 0;
        int light = 0;

        while (index < str.length) {
            if (str[index] == 'X') {
                index++;
            } else {
                light++;
                if (index + 1 == str.length) {
                    break;
                } else {
                    if (str[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }
                }
            }
        }
        return light;
    }

    public static String randomString(int len) {
        char[] res = new char[(int) (Math.random() * len) + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.random() < 0.5 ? 'X' : '.';
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        int len = 20;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            String test = randomString(len);
            int ans1 = minLight1(test);
            int ans2 = minLight2(test);
            if (ans1 != ans2){
                System.out.println("Oops");
            }
        }
        System.out.println("test finished");
    }
}
