package com.story.algorithm.study6;

public class SmallerEqualBigger {

    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartition1(Node head,int pivot){
        if (head == null) return head;
        Node cur = head;
        int i = 0;
        //遍历链表长度
        while (cur !=null){
            i++;
            cur = cur.next;
        }

        //声明额外空间O(N)的数组存储每个节点
        Node[] nodes =new Node[i];
        //i = 0;
        cur = head;
        for (i = 0;i != nodes.length;i++){
            nodes[i] = cur;
            cur = cur.next;
        }
        //进行partition分区，将小于pivot区放置小于区，大于pivot放置大于区
        arrPartition(nodes,pivot);
        //将分区好的数组重新连接成链表
        for (i = 1; i != nodes.length;i++){
            nodes[i-1].next =nodes[i];
        }
        //将尾节点下一个节点指向null
        nodes[i-1].next = null;
        return nodes[0];
    }

    private static void arrPartition(Node[] nodes, int pivot) {
        int small = -1;
        int big = nodes.length;
        int index = 0;
        while (index != big){
            if (nodes[index].value < pivot){
                swap(nodes,++small,index++);
            }else if (nodes[index].value == pivot){
                index++;
            }else {
                swap(nodes,--big,index);
            }
        }
    }

    private static void swap(Node[] nodes, int i, int j) {
        Node tmp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = tmp;
    }

    public static Node listPartition2(Node head,int pivot){
        Node sH = null;//small head
        Node sT = null;//small tail
        Node eH = null;//equal head
        Node eT = null;//equal tail
        Node bH = null;//big head
        Node bT = null;//big tail
        Node next = null; // 用来保存下一个节点

        while (head != null){
            next = head.next;
            head.next = null;
            //将链表 分成三个区域 ，即（<pivot,=pivot,>pivot）
            if (head.value < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if (head.value == pivot){
                if (eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if (bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        //小于区的尾巴连等于区的头，等于区的尾巴连大于区的头
        if (sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;//下一步谁去连接大于区的头，如果等于区不存在就小于区的尾巴连接大于区，否则等于区的尾巴连接大于区的头
        }

        //如果存在等于区，重新连接大于区的头
        if (eT != null){
            eT.next = bH;
        }

        //返回头
        return sH != null ? sH : (eH != null ? eH : bH);
    }

    public static void printLinkedList(Node node){
        System.out.print("linked list:");
        while (node!= null){
            System.out.print(node.value + "\t");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(9);
        head.next.next = new Node(1);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(5);
        printLinkedList(head);
        //head = listPartition1(head,5);
        head = listPartition2(head,10);
        printLinkedList(head);

    }


}
