package com.story.algorithm.study6;

import java.util.HashMap;

public class CopyListWithRandom {
    public static class Node {
        private int value;
        private Node next;
        private Node random;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node copyListWithRnadom1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        //用cur作为key，new Node(cur.value)作为值新建一个键值对
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            //cur老的 ,map.get(cur)新的
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    public static Node copyListWithRnadom2(Node head) {
        if (head == null) return null;
        Node cur = head;
        Node next = cur;

        //复制每一个节点并且链接成一个链表
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        Node curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur= next;
        }
        return res;
    }

    public static void printRandomLinkedList(Node head){
        Node cur = head;
        System.out.print("order : ");
        while (cur != null){
            System.out.print(cur.value + "\t");
            cur = cur.next;
        }
        System.out.println();

        cur = head;
        System.out.print("random: ");
        while(cur != null){
            System.out.print(cur.random == null ? "-\t" :  cur.random.value + "\t");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head=  null;
        Node res1 = null;
        Node res2 = null;
        printRandomLinkedList(head);
        res1 = copyListWithRnadom1(head);
        printRandomLinkedList(res1);
        /*res2 = copyListWithRnadom2(head);
        printRandomLinkedList(res2);
        printRandomLinkedList(head);
        System.out.println("==========================");*/

        head = new Node(1);
        head.next =new Node(2);
        head.next.next =new Node(3);
        head.next.next.next =new Node(4);
        head.next.next.next.next =new Node(5);
        head.next.next.next.next.next =new Node(6);

        head.random = head.next.next.next.next.next; // 1->6
        head.next.random = head.next.next.next.next.next; //2->6
        head.next.next.random = head.next.next.next.next; // 3->5
        head.next.next.next.random = head.next.next; // 4->3
        head.next.next.next.next.random = null; // 5->null
        head.next.next.next.next.next.random = head.next.next.next; // 6->4

        printRandomLinkedList(head);
        System.out.println("=================");
        res1 = copyListWithRnadom1(head);
        printRandomLinkedList(res1);
        res2 = copyListWithRnadom2(head);
        printRandomLinkedList(res2);
        printRandomLinkedList(head);
        System.out.println("=================");
    }
}
