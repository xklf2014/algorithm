package com.story.algorithm.study6;

import java.util.ArrayList;

public class LinkedListMid {

    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public static Node midOrUpMidNode(Node head){
        if (head == null || head.next == null || head.next.next ==null){
            return head;
        }

        //此时链表中存在至少3个节点
        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //返回上中点或者中点
        return slow;

    }

    public static Node midOrDownMidNode(Node head){
        if (head == null || head.next == null || head.next.next ==null){
            return head;
        }

        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //返回下中点或者中点
        return slow;
    }

    public static Node midOrUpMidPreNode(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }

        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node midOrDownPreNode(Node head){
        if (head == null || head.next == null){
            return null;
        }

        if (head.next.next == null) return head;

        Node slow = head;
        Node fast = head.next;

        while (fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node right1(Node head){
        if (head == null) return null;

        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null){
            arr.add(cur);
            cur = cur.next;
        }

        return arr.get((arr.size()-1)/2);
    }

    public static Node right2(Node head){
        if (head == null) return null;

        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null){
            arr.add(cur);
            cur = cur.next;
        }

        return arr.get((arr.size())/2);
    }

    public static Node right3(Node head){
        if (head == null || head.next == null || head.next.next == null) return null;
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null){
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size()-3)/2);

    }


    public static Node right4(Node head){
        if (head == null || head.next == null){
            return null;
        }

        if (head.next.next == null){
            return head;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null ){
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size()-2)/2);

    }

    public static void main(String[] args) {
        Node n1 =null;
        n1 = new Node(0);
        n1.next = new Node(1);
        n1.next.next = new Node(2);
        n1.next.next.next = new Node(3);
//        n1.next.next.next.next= new Node(4);
//        n1.next.next.next.next.next = new Node(5);
//        n1.next.next.next.next.next.next = new Node(6);
//        n1.next.next.next.next.next.next.next = new Node(7);
//        n1.next.next.next.next.next.next.next.next = new Node(8);
//        n1.next.next.next.next.next.next.next.next.next = new Node(9);

        Node ans1 = null;
        Node ans2 = null;

        ans1 = midOrUpMidNode(n1);
        ans2 = right1(n1);
        System.out.println(ans1==null?null:ans1.value);
        System.out.println(ans2==null?null:ans2.value);

        ans1 = midOrDownMidNode(n1);
        ans2 = right2(n1);
        System.out.println(ans1==null?null:ans1.value);
        System.out.println(ans2==null?null:ans2.value);

        ans1 = midOrUpMidPreNode(n1);
        ans2 = right3(n1);
        System.out.println(ans1==null?null:ans1.value);
        System.out.println(ans2==null?null:ans2.value);

        ans1 = midOrDownPreNode(n1);
        ans2 = right4(n1);
        System.out.println(ans1==null?null:ans1.value);
        System.out.println(ans2==null?null:ans2.value);
    }

}
