package com.story.algorithm.study8;

import java.util.ArrayList;

public class IsBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBST1(Node head) {
        if (head == null) return true;

        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return false;
            }
        }
        return true;
    }

    private static void in(Node head, ArrayList<Node> arr) {
        if (head == null) return;
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static boolean isBST2(Node head) {
        if (head == null) return true;
        return process(head).isBST;
    }

    private static Info process(Node head) {
        if (head == null) return null;
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int min = head.value;
        int max = head.value;

        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }

        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }

        boolean isBST = false;

        if (    //如果左树为空，则为平衡树，否则需要满足左树是平衡树且左树最大值要小于头节点
                (leftInfo == null ? true : (leftInfo.isBST && leftInfo.max < head.value))
                        &&
                        //如果右树为空，则为平衡树，否则需要满足右树是平衡树且右树最小节点大于头节点
                        (rightInfo == null ? true : (rightInfo.isBST && rightInfo.min > head.value))
        ) {
            isBST = true;
        }
        return new Info(isBST,max,min);

    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static Node generateRandomBST(int maxLevel,int maxValue){
        return generate(1,maxLevel,maxValue);
    }

    private static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5)return null;

        Node head = new Node((int)(Math.random() * maxValue));
        head.left = generate(level+1,maxLevel,maxValue);
        head.right = generate(level+1,maxLevel,maxValue);

        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue =100;
        int testTimes = 10000;

        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBST1(head) != isBST2(head)){
                System.out.println("Oops");
            }
        }
        System.out.println("test finished");
    }
}
