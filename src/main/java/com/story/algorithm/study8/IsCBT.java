package com.story.algorithm.study8;

import java.util.LinkedList;

public class IsCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT1(Node head) {
        if (head == null) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);

        while (!queue.isEmpty()) {
            if (leaf && (l != null || r != null) || (l != null || r == null)) {
                return false;
            }

            if (l != null) {
                queue.add(l);
            }

            if (r != null) {
                queue.add(r);
            }

            if (l == null || r == null) {
                leaf = true;
            }
        }

        return true;

    }

    public static boolean isCBT2(Node head){
        if (head == null) return true;
        return process(head).isCBT;
    }

    private static Info process(Node head) {
        if (head == null) return new Info(true,true,0);

        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;

        boolean isCBT =false;
        if (isFull){
            isCBT = true;
        }else{
            if (leftInfo.isCBT && rightInfo.isCBT){
                if (leftInfo.isCBT && rightInfo.isFull && leftInfo.height == rightInfo.height + 1){
                    isCBT =true;
                }

                if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height + 1){
                    isCBT =true;
                }

                if (leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height){
                    isCBT = true;
                }
            }
        }
        return new Info(isFull,isCBT,height);
    }

    public static class Info{
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }
}
