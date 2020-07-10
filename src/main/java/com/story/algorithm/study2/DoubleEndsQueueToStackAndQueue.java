package com.story.algorithm.study2;

public class DoubleEndsQueueToStackAndQueue {
    public static class Node<T>{
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", last=" + last +
                    ", next=" + next +
                    '}';
        }
    }

    public static class DoubleEndsQueue<T>{
        public Node<T> head;
        public Node<T> tail;

        public  void addFromHead(T value){
            Node<T> cur = new Node<T>(value);
            if (head != null){
                head = cur;
                tail = cur;
            }else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }

        }
    }


}
