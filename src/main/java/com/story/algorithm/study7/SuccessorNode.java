package com.story.algorithm.study7;

public class SuccessorNode {

    public static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    /*返回给出节点的后继节点
        当前节点是父节点的左孩子，则父节点为后继节点
        当前节点为父节点的右孩子，则其父节点是祖父节点的左孩子，则祖父几点为后继节点
        当前节点为整棵树最右节点，则null为当前节点的后继节点
    * */
    public static Node getSuccessorNode(Node node) {
        if (node == null) return node;

        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.right == node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getLeftMost(Node node) {
        if (node == null) return node;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void printTree(Node head){
        System.out.println("Binary Tree:");
        printInOrder(head,0,"H",17);
        System.out.println();
    }

    private static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) return;
        printInOrder(head.right,height+1,"v",len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL =(len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) +val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left,height+1,"^",len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        printTree(head);
        System.out.println("==================");
        Node test = head.left.left;
        System.out.println(test.value + " next: "+ getSuccessorNode(test).value);

        test = head.left.left.right;
        System.out.println(test.value + " next: "+ getSuccessorNode(test).value);

        test = head.left;
        System.out.println(test.value + " next: "+ getSuccessorNode(test).value);

        test = head.left.right;
        System.out.println(test.value + " next: "+ getSuccessorNode(test).value);

        test = head.left.right.right;
        System.out.println(test.value + " next: "+ getSuccessorNode(test).value);

        test = head;
        System.out.println(test.value + " next: "+ getSuccessorNode(test).value);

        test =head.right.left.left;
        System.out.println(test.value + " next: "+ getSuccessorNode(test).value);

        test = head.right.left;
        System.out.println(test.value + " next: "+ getSuccessorNode(test).value);

        test = head.right;
        System.out.println(test.value + " next: "+ getSuccessorNode(test).value);

        test = head.right.right;
        System.out.println(test.value + " next: "+ getSuccessorNode(test));
    }

}
