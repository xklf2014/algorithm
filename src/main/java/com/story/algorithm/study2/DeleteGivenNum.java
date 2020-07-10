package com.story.algorithm.study2;

public class DeleteGivenNum {
    public static class Node{
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static Node removeValue(Node head,int num){
        //循环遍历，确认最终头部
        while (head != null){
            if (head.value != num){
                break;
            }
            head = head.next;
        }
        //head来到第一个不需要删除的位置
        Node pre = head;
        Node cur =head;
        //循环将后续等于给予数字相同的节点进行删除
        while (cur != null){
            if (cur.value == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(removeValue(node1, 2).toString());
    }

}
