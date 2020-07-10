package com.story.algorithm.study2;

import java.util.HashMap;

public  class ReverseList {

    public static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class DoubleNode{
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;

        while ( head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;

    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;

        Node node = reverseLinkedList(n1);
        System.out.println(node.value);

        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);

        node1.last = null;
        node1.next = node2;
        node2.last = node1;
        node2.next = node3;
        node3.last = node2;
        node3.next = null;
        System.out.println(reverseDoubleList(node3).value);
    }


}
