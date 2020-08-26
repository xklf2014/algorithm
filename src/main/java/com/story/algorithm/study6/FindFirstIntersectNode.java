package com.story.algorithm.study6;

public class FindFirstIntersectNode {
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }

        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }

        return null;
    }

    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;

        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }

            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }

            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;

        }else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) return null; //cur1 ==cur2 即2个节点想交于最后一个节点
        //n为链表1和链表2之间的差值
        cur1 = n > 0 ? head1 : head2;//谁长谁的头变成cur1
        cur2 = cur1 == head1 ? head2 : head1;//谁短谁的头变成cur2
        n = Math.abs(n);

        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //找到链表第一个入环节点，无环返回null
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node n1 = head.next;//slow
        Node n2 = head.next.next;//fast
        //有环则快慢指针必定想交于环中某一点
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        //出循环即找到环中想交点
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        //再次相交节点为入环第一个相交节点
        return n1;

    }


    public static void main(String[] args) {
        //无环想交
       /* // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        //0-9-8-6-7-null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next;

        System.out.println(getIntersectNode(head1,head2).value);*/


        /*//有环,环外相交
        // 1->2->3->4->5->6->7->4...入环
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = head1.next.next.next;

        //0->9->8->2....重合
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next;
        System.out.println(getIntersectNode(head1,head2));*/

        //有环,环外相交
        // 1->2->3->4->5->6->7->4...入环
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = head1.next.next.next;

        //0->9->8->5....重合
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next;
        System.out.println(getIntersectNode(head1,head2).value);
    }


}
