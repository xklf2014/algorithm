package com.story.algorithm.study9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class LowestLexicography {

    public static String lowestString1(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        ArrayList<String> all = new ArrayList<>();
        HashSet<Integer> use = new HashSet<>();
        process(strs, use, "", all);
        String lowest = all.get(0);
        for (int i = 1; i < all.size(); i++) {
            if (all.get(i).compareTo(lowest) < 0) {
                lowest = all.get(i);
            }
        }
        return lowest;
    }

    /*
     *   strs存放所有字符串
     *   已经使用过的字符串下标放置到use，不可继续使用
     *   之前使用过的字符串，拼接成path
     *   用all收集所有拼接结果
     * */
    private static void process(String[] strs, HashSet<Integer> use, String path, ArrayList<String> all) {
        if (use.size() == strs.length) {
            all.add(path);
        } else {
            for (int i = 0; i < strs.length; i++) {
                if (!use.contains(i)) {
                    use.add(i);
                    process(strs, use, path + strs[i], all);
                    use.remove(i);
                }
            }
        }
    }

    public static class MyCompartor implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return ((a + b).compareTo(b + a));
        }
    }


    public static String lowestString2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyCompartor());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 5);
            ans[i] = (Math.random() < 0.5) ? (char) (65 + value) : (char) (97 + value);
        }
        return String.valueOf(ans);
    }

    public static String[] generateRandomStringArray(int arrlen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrlen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

    public static String[] copyStringArray(String[] arr) {
        String[] ans = new String[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = String.valueOf(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arrLen = 5;
        int strLen = 5;
        int testTimes = 100;
        String[] arr = generateRandomStringArray(arrLen, strLen);
        System.out.println("预览新生成的数组");
        for (String str : arr) {
            System.out.print(str + ",");
        }

        System.out.println();
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            String[] a1 = copyStringArray(arr);
            String[] a2 = copyStringArray(arr);

            if (!lowestString1(a1).equals(lowestString2(a2))) {
                for (String st1 : a1) {
                    System.out.print(st1 + ",");
                }
                System.out.println();
                System.out.println("-----------------");
                for (String st2 : a2) {
                    System.out.print(st2 + ",");
                }
                System.out.println();
                System.out.println("Oops");
            }
        }
        System.out.println(lowestString1(arr));
        System.out.println("test finished");
    }
}
