package com.story.algorithm.study5;

import java.util.Arrays;
import java.util.HashMap;

public class TrieTree2 {
    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            pass = 0;
            end = 0;
            nexts = new Node1[26]; //默认0-25,对应26个小写英文字母
        }
    }

    public static class Tire1 {
        private Node1 root;

        public Tire1() {
            root = new Node1();
        }

        public void insert(String word) {
            if (word == null) return;
            //将字符串转换成char数组
            char[] chars = word.toCharArray();
            Node1 node = root;
            node.pass++; //字符串不为空，则头节点必然递增1

            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) {
                    node.nexts[path] = new Node1();
                }

                node = node.nexts[path]; //跳转当前节点的下一个节点
                node.pass++;
            }
            node.end++; //走完所有的路，end++
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                Node1 node = root;
                node.pass--;

                int path = 0;
                for (int i = 0; i < chars.length; i++) {
                    path = chars[i] - 'a';
                    //判断-1后的这条路是否等于0，如果等于0，则后续操作皆为冗余操作，
                    // 直接将当前节点的nexts设置为null，交由jvm进行回收即可
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }

        private int search(String word) {
            if (word == null) return 0;

            char[] chars = word.toCharArray();
            Node1 node = root;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) return 0;
                node = node.nexts[path];
            }
            return node.end; //返回当前节点的end值，即改资费串加入过几次

        }

        //返回所有加入的字符串中，有多少个字符是pre这个字符作为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) return 0;
            char[] chars = pre.toCharArray();
            Node1 node = root;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = chars[i] - 'a';
                if (node.nexts[path] == null) return 0;
                node = node.nexts[path];
            }
            return node.pass;
        }
    }

    public static class Node2 {
        public int pass;
        public int end;
        public HashMap<Integer, Node2> nexts;

        public Node2() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }

    }

    public static class Trie2 {
        private Node2 root;

        public Trie2() {
            this.root = new Node2();
        }

        public void insert(String str) {
            if (str == null) {
                return;
            }

            char[] chars = str.toCharArray();
            Node2 node = root;
            node.pass++;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = (int) chars[i];
                if (!node.nexts.containsKey(path)) {
                    node.nexts.put(path, new Node2());
                }
                node = node.nexts.get(path);
                node.pass++;
            }
            node.end++;
        }

        public void delete(String str) {
            if (search(str) != 0) {
                char[] chars = str.toCharArray();
                Node2 node = root;
                node.pass--;
                for (int i = 0; i < chars.length; i++) {
                    int path = (int) chars[i];
                    if (--node.nexts.get(path).pass == 0) {
                        node.nexts.remove(path);
                        return;
                    }
                    node = node.nexts.get(path);
                }
                node.end--;
            }
        }

        private int search(String str) {
            if (str == null) return 0;
            char[] chars = str.toCharArray();
            Node2 node = root;
            int path = 0;

            for (int i = 0; i < chars.length; i++) {
                path = (int) chars[i];
                if (!node.nexts.containsKey(path)) return 0;
                node = node.nexts.get(path);
            }

            return node.end;
        }

        public int prefixNumber(String pre) {
            if (pre == null) return 0;
            char[] chars = pre.toCharArray();
            Node2 node = root;
            int path = 0;
            for (int i = 0; i < chars.length; i++) {
                path = (int) chars[i];
                if (!node.nexts.containsKey(path)) return 0;
                node = node.nexts.get(path);
            }
            return node.pass;
        }

        public static class Right {
            private HashMap<String, Integer> box;

            public Right() {
                box = new HashMap<>();
            }

            public void insert(String str) {
                if (!box.containsKey(str)) {
                    box.put(str, 1);
                } else {
                    box.put(str, box.get(str) + 1);
                }
            }

            public void delete(String str) {
                if (box.containsKey(str)) {
                    if (box.get(str) == 1) {
                        box.remove(str);
                    } else {
                        box.put(str, box.get(str) - 1);
                    }
                }
            }

            public int search(String str) {
                if (!box.containsKey(str)) return 0;
                return box.get(str);
            }

            public int getPrefixNumber(String pre) {
                int count = 0;
                for (String cur : box.keySet()) {
                    if (cur.startsWith(pre)) {
                        count += box.get(cur);
                    }
                }
                return count;

            }
        }


        public static String generateRandmomString(int strLen) {
            char[] ans = new char[(int) (Math.random() * strLen) + 1];
            for (int i = 0; i < ans.length; i++) {
                int value = (int) (Math.random() * 6);
                ans[i] = (char) (97 + value);
            }
            return String.valueOf(ans);
        }

        public static String[] generateRandomStringArray(int arrLen, int strLen) {
            String[] ans = new String[(int) (Math.random() * arrLen) + 1];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = generateRandmomString(strLen);
            }
            return ans;
        }

        public static void main(String[] args) {
            int arrLen = 20;
            int strLen = 20;
            int testTimes = 10000;
            System.out.println("test begin");
            for (int i = 0; i < testTimes; i++) {
                String[] arr = generateRandomStringArray(arrLen,strLen);
                Tire1 tire1 = new Tire1();
                Trie2 trie2 = new Trie2();
                Right right = new Right();
                for (int j = 0; j < arr.length; j++) {
                    double decide =Math.random();
                    if (decide < 0.25){
                        tire1.insert(arr[j]);
                        trie2.insert(arr[j]);
                        right.insert(arr[j]);
                    }else if (decide < 0.5){
                        tire1.delete(arr[j]);
                        trie2.delete(arr[j]);
                        right.delete(arr[j]);
                    }else if (decide < 0.75){
                        int search = tire1.search(arr[j]);
                        int search1 = trie2.search(arr[j]);
                        int search2 = right.search(arr[j]);
                        if (search != search1 || search1 != search2){
                            System.out.println("Oops1");
                        }
                    }else {
                        int i1 = tire1.prefixNumber(arr[j]);
                        int i2 = trie2.prefixNumber(arr[j]);
                        int i3 = right.getPrefixNumber(arr[j]);
                        if (i1 != i2 || i2 != i3){
                            System.out.println("Oops2");
                        }
                    }
                }
            }
            System.out.println("test end");

        }
    }
}
