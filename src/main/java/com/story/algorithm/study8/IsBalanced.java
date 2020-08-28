package com.story.algorithm.study8;

public class IsBalanced {
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBalanced1(Node head){
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head,ans);
        return ans[0];
    }

    private static int process1(Node head, boolean[] ans) {
        if (!ans[0] || head == null) return -1;

        int leftHeight = process1(head.left,ans);
        int rightHeight = process1(head.right,ans);
        if (Math.abs(leftHeight - rightHeight) > 1){
            ans[0] = false;
        }
        return Math.max(leftHeight,rightHeight) + 1;
    }

    public static boolean isBalanced2(Node head){
        return process2(head).isBalanced;
    }

    public static class Info{
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    private static Info process2(Node X) {
        if (X == null) return new Info(true,0);

        Info leftInfo = process2(X.left);
        Info rightInfo = process2(X.right);
        int height = Math.max(leftInfo.height,rightInfo.height) + 1;
        boolean isBalanced = true;
        //左右节点，任意一点不平衡，且左右节点高度差大于1，皆可判定此树为非平衡树
        if (!leftInfo.isBalanced || !rightInfo.isBalanced || Math.abs(leftInfo.height-rightInfo.height)>1){
            isBalanced = false;
        }
        return new Info(isBalanced,height);
    }

    public static Node generateRandomBST(int maxLevel,int maxValue){
        return generate(1,maxLevel,maxValue);
    }

    private static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5){
            return null;
        }
        Node head = new Node((int)(Math.random()) * maxValue);
        head.left = generate(level + 1,maxLevel,  maxValue);
        head.right = generate(level + 1,maxLevel, maxValue);

        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000;
        for (int i = 0;i<testTimes;i++){
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBalanced1(head) != isBalanced2(head)){
                System.out.println("Oops");
            }
        }
        System.out.println("finished");
    }
}
