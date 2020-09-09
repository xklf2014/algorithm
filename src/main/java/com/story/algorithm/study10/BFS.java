package com.story.algorithm.study10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//宽度优先遍历
public class BFS {

    public static void bfs(Node node){
        if (node == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        HashSet set = new HashSet();
        queue.add(node);
        set.add(node);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for ( Node next :cur.nexts){
                if (!set.contains(next)){
                    set.add(next);
                    queue.add(next);
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

        bfs(head);
    }
}
