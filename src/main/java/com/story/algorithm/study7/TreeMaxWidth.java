package com.story.algorithm.study7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxWidthUseMap(Node head) {
        if (head == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }

            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static int maxWidthNoMap(Node head) {
        if (head == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head; //当前层的最右节点
        Node nextEnd = null;//下一层最右节点

        int max = 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }

            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }

            curLevelNodes++;
            if (cur == curEnd) {
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }

    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    private static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) return;
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 100;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel,maxValue);
            //printTree(head);
            if (maxWidthNoMap(head) != maxWidthUseMap(head)){
                //System.out.println("maxWidthNoMap"+maxWidthNoMap(head));
                //System.out.println("maxWidthUseMap"+maxWidthUseMap(head));
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("finish");
       /* Node head = new Node(35);
        head.right = new Node(16);
        head.right.right = new Node(66);
        head.right.right.left = new Node(3);
        head.right.right.right = new Node(60);
        head.right.right.left.left = new Node(64);
        head.right.right.left.right = new Node(46);
        head.right.right.right.left = new Node(91);
        printTree(head);
        if (maxWidthNoMap(head) != maxWidthUseMap(head)) {
            System.out.println("maxWidthNoMap" + maxWidthNoMap(head));
            System.out.println("maxWidthUseMap" + maxWidthUseMap(head));
            System.out.println("Oops");
        }*/
    }
}
