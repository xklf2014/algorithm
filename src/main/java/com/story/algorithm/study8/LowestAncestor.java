package com.story.algorithm.study8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LowestAncestor {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public static Node lowestAncestor1(Node head, Node n1, Node n2) {
        if (head == null) return null;

        //节点地图，记录树的父子关系
        HashMap<Node, Node> parentMap = new HashMap<>();
        parentMap.put(head, null);
        fillParentMap(head, parentMap);
        HashSet<Node> o1set = new HashSet<>();
        Node cur = n1;
        o1set.add(cur);

        //沿途将n1所有父节点加入的set中
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            o1set.add(cur);
        }
        cur = n2;
        while (!o1set.contains(cur)) {
            cur = parentMap.get(cur);
        }
        return cur;
    }

    private static void fillParentMap(Node head, HashMap<Node, Node> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            fillParentMap(head.left, parentMap);
        }

        if (head.right != null) {
            parentMap.put(head.right, head);
            fillParentMap(head.right, parentMap);
        }
    }

    public static Node lowestAncestor2(Node head, Node n1, Node n2) {
        return process(head, n1, n2).ans;
    }

    private static Info process(Node X, Node n1, Node n2) {
        if (X == null) return new Info(null, false, false);
        Info leftInfo = process(X.left, n1, n2);
        Info rightInfo = process(X.right, n1, n2);

        boolean findN1 = X == n1 || leftInfo.findN1 || rightInfo.findN1;
        boolean findN2 = X == n2 || leftInfo.findN2 || rightInfo.findN2;
        /*确定n1和n2最终在那里想交，列出如下可能性：
            （1） 在左树上提前想交
            （2） 在右树上提前想交
            （3） 没有在左树与右树上提前想交，即头结点想交
        */
        Node ans = null;
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
        }
        if (rightInfo.ans != null) {
            ans = rightInfo.ans;
        }

        if (ans == null) {
            if (findN1 && findN2) {
                ans = X;
            }
        }
        return new Info(ans, findN1, findN2);
    }

    public static class Info {
        public Node ans;
        public boolean findN1;
        public boolean findN2;

        public Info(Node ans, boolean findN1, boolean findN2) {
            this.ans = ans;
            this.findN1 = findN1;
            this.findN2 = findN2;
        }
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

    public static Node pickRandomOne(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> arr = new ArrayList<>();
        fillPreList(head,arr);
        int randomIndex = (int)(Math.random() * arr.size());
        return arr.get(randomIndex);
    }

    private static void fillPreList(Node head, ArrayList<Node> arr) {
        if (head == null){
            return;
        }
        arr.add(head);
        fillPreList(head.left,arr);
        fillPreList(head.right,arr);
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 100;
        Node ans = null;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            Node n1 = pickRandomOne(head);
            //System.out.println(n1);
            Node n2 = pickRandomOne(head);
            //System.out.println(n2);
            if (lowestAncestor1(head,n1,n2) != lowestAncestor2(head,n1,n2)){
                System.out.println("Oops");
            }
            ans = lowestAncestor2(head,n1,n2);
        }
        System.out.println("相交于: \t" + ans);
        System.out.println("test finished");
    }

}
