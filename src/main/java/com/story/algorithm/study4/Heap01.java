package com.story.algorithm.study4;

import java.util.Arrays;

public class Heap01 {
    public static class MyMaxHeap {
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit) {
            this.heap = new int[limit];
            this.limit = limit;
            this.heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full!!!");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        //从index位置往下找，直到所有孩子都没有自己大的时候停
        private void heapify(int[] arr, int index, int heapSize) {
            int left = ((index << 1) | 1);
            while (left < heapSize) {
                //判断有有孩子，然后左右孩子pk，取出最大的孩子下标
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                //当前父节点和最大孩子节点pk，更新largest下标
                largest = arr[largest] > arr[index] ? largest : index;
                //如果最大节点等于当前节点，则停止比较
                if (largest == index) {
                    break;
                }

                //执行交换，更新下标，然后重新获取左孩子节点，继续循环，直到left > heapSize或者largest == index
                swap(arr, index, largest);
                index = largest;
                left = ((index << 1) | 1);
            }
        }

        private void heapInsert(int[] arr, int index) {
            while (arr[index] > arr[(index - 1) / 2]) {
                swap(arr, index, ((index - 1) / 2));
                index = (index - 1) / 2;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            this.arr = new int[limit];
            this.limit = limit;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }
    }

    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int times = 1000;

        for (int i = 0; i < times; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyMaxHeap myMaxHeap = new MyMaxHeap(curLimit);
            RightMaxHeap rightMaxHeap = new RightMaxHeap(curLimit);

            int curOpTimes = (int)(Math.random() * limit);
            for (int j = 0;j<curOpTimes;j++){
                if (myMaxHeap.isEmpty() != rightMaxHeap.isEmpty()){
                    System.out.println("Oops");
                    break;
                }

                if (myMaxHeap.isFull() != rightMaxHeap.isFull()) {
                    System.out.println("Oops");
                    break;
                }

                if (myMaxHeap.isEmpty()){
                    int curValue = (int)(Math.random() * value);
                    myMaxHeap.push(curValue);
                    rightMaxHeap.push(curValue);
                }else if(myMaxHeap.isFull()){
                    if (myMaxHeap.pop() != rightMaxHeap.pop()){
                        System.out.println("Oops");
                        break;
                    }
                }else {
                    if (Math.random() < 0.5){
                        int curValue = (int)(Math.random() * value);
                        myMaxHeap.push(curValue);
                        rightMaxHeap.push(curValue);
                    }else {
                        if (myMaxHeap.pop() != rightMaxHeap.pop()){
                            System.out.println("Oops");
                            break;
                        }
                    }
                }
            }
        }
    }
}
