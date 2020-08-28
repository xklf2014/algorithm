package com.story.algorithm.study8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MaxDistance {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxDistance1(Node head) {
        if (head == null) return 0;

        ArrayList<Node> arr = getPreList(head);
        HashMap<Node, Node> parentMap = getParentMap(head);

        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                max = Math.max(max, distance(parentMap, arr.get(i), arr.get(j)));
            }
        }
        return max;
    }

    private static int distance(HashMap<Node, Node> parentMap, Node n1, Node n2) {
        HashSet<Node> o1Set = new HashSet<>();
        Node cur = n1;
        o1Set.add(cur);
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            o1Set.add(cur);
        }
        cur = n2;
        while (!o1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }

        Node lowestAncestor = cur;
        cur = n1;
        int distance1 = 1;
        while (cur != lowestAncestor) {
            cur = parentMap.get(cur);
            distance1++;
        }

        int distance2 = 1;
        cur = n2;
        while (cur != lowestAncestor) {
            cur = parentMap.get(cur);
            distance2++;
        }
        return distance1 + distance2 - 1;

    }

    private static HashMap<Node, Node> getParentMap(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, null);
        fillParentMap(head, map);
        return map;
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

    private static ArrayList<Node> getPreList(Node head) {
        ArrayList<Node> arr = new ArrayList<>();
        fillPreList(head, arr);
        return arr;
    }

    private static void fillPreList(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }

        arr.add(head);
        fillPreList(head.left, arr);
        fillPreList(head.right, arr);
    }

    public static int maxDistance2(Node head) {
        return process(head).maxDistance;
    }

    private static Info process(Node X) {
        if (X == null) return new Info(0, 0);

        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance),
                leftInfo.height + rightInfo.height + 1);
        return new Info(maxDistance,height);

    }

    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    public static Node generateRandomBST(int maxLevel,int maxValue){
        return generate(1,maxLevel,maxValue);
    }

    private static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5){
            return null;
        }
        Node head = new Node((int)(Math.random()*maxValue));
        head.left = generate(level+1,maxLevel,maxValue);
        head.right = generate(level + 1,maxLevel,maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue =100;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxLevel);
            //System.out.println("d1"+maxDistance1(head));
            //System.out.println("d2"+maxDistance2(head));
            if (maxDistance1(head)!=maxDistance2(head)){
                System.out.println("Oops");
            }
        }
        System.out.println("test finished");
    }
}
