package com.story.algorithm.study6;

import java.util.Stack;

//回文
public class IsPalindromeList {
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //需要额外n长度空间
    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;

    }

    //需要额外n/2的空间
    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null)
            return true;

        Node right = head.next;
        Node cur = head;

        while (cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }

        Stack<Node> stack = new Stack<>();
        while (right != null){
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head){
        if (head == null || head.next == null){
            return true;
        }

        Node n1 = head;
        Node n2 = head;

        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;//得到中点或者上中点
            n2 = n2.next.next; //得到终点
        }

        n2 = n1.next; //获取到n2的第一个node
        n1.next = null;
        Node n3 =null;

        //翻转指向，将2投指针指向中点
        while (n2 != null){
            n3 = n2.next; //临时节点，用于保存n2的下一个节点
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1;//尾节点
        n2 = head;//头结点
        boolean res = true;
        //循环比较，如果任何对应节点不相等，返回false
        while ( n1 != null && n2 != null){
            if (n1.value != n2.value){
                res =  false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        //比较完成后，恢复链表
        n1 = n3.next;
        n3.next = null;
        while (n1 != null ){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }

    public static void printLinkedList(Node node){
        System.out.print("Linked list:");
        while (node !=null){
            System.out.print(node.value + "\t");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        /*printLinkedList(head);
        System.out.println(isPalindrome1(head) + " 1");
        System.out.println(isPalindrome2(head) + " 2");
        System.out.println(isPalindrome3(head) + " 3");
        printLinkedList(head);
        System.out.println("==================");

        head = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome1(head) + " 1");
        System.out.println(isPalindrome2(head) + " 2");
        System.out.println(isPalindrome3(head) + " 3");
        printLinkedList(head);
        System.out.println("==================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.println(isPalindrome1(head) + " 1");
        System.out.println(isPalindrome2(head) + " 2");
        System.out.println(isPalindrome3(head) + " 3");
        printLinkedList(head);
        System.out.println("==================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome1(head) + " 1");
        System.out.println(isPalindrome2(head) + " 2");
        System.out.println(isPalindrome3(head) + " 3");
        printLinkedList(head);
        System.out.println("==================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.println(isPalindrome1(head) + " 1");
        System.out.println(isPalindrome2(head) + " 2");
        System.out.println(isPalindrome3(head) + " 3");
        printLinkedList(head);
        System.out.println("==================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome1(head) + " 1");
        System.out.println(isPalindrome2(head) + " 2");
        System.out.println(isPalindrome3(head) + " 3");
        printLinkedList(head);
        System.out.println("==================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome1(head) + " 1");
        System.out.println(isPalindrome2(head) + " 2");
        System.out.println(isPalindrome3(head) + " 3");
        printLinkedList(head);
        System.out.println("==================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome1(head) + " 1");
        System.out.println(isPalindrome2(head) + " 2");
        System.out.println(isPalindrome3(head) + " 3");
        printLinkedList(head);
        System.out.println("==================");*/

        /*head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome1(head) + " 1");
        System.out.println(isPalindrome2(head) + " 2");
        System.out.println(isPalindrome3(head) + " 3");
        printLinkedList(head);
        System.out.println("==================");*/

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome1(head) + " 1");
        System.out.println(isPalindrome2(head) + " 2");
        System.out.println(isPalindrome3(head) + " 3");
        printLinkedList(head);
        System.out.println("==================");
    }


}


