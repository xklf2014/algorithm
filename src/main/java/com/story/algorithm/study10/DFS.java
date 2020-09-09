package com.story.algorithm.study10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

//深度优先遍历
public class DFS {
    public static void dfs(Node node){
        if (node == null) return;

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for (Node next : cur.nexts){
                if (!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node c1 = new Node(2);
        Node c2 = new Node(3);
        Node c3 = new Node(4);
        ArrayList<Node> hNexts = new ArrayList<>();
        hNexts.add(c1);
        hNexts.add(c2);
        hNexts.add(c3);
        head.nexts = hNexts;

        Node c11 = new Node(5);
        Node c12 = new Node(6);
        Node c13 = new Node(7);
        ArrayList<Node> c1Nexts = new ArrayList<>();
        c1Nexts.add(c11);
        c1Nexts.add(c12);
        c1Nexts.add(c13);
        c1.nexts = c1Nexts;

        dfs(head);
    }
}
