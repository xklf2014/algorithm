package com.story.algorithm.study2;

import java.util.Arrays;
import java.util.Stack;

public class TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        public Stack<Integer> pushStack;
        public Stack<Integer> popStack;

        public TwoStacksQueue() {
            this.pushStack = new Stack<>();
            this.popStack = new Stack<>();
        }

        //从push栈导入到pop栈,必须一次性导入完成
        public void pushToPop() {
            if (this.popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }

        public void add(int pushInt) {
            pushStack.push(pushInt);
            pushToPop();
        }

        public int poll() {
            if (this.pushStack.isEmpty() && this.popStack.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return this.popStack.pop();
        }

        public int peek() {
            if (this.pushStack.isEmpty() && this.popStack.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            this.pushToPop();
            return this.popStack.peek();
        }

    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(5);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
