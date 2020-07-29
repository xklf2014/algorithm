package com.story.algorithm.study4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {
    //额外空间复杂度O(1)
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //O(n * logN)
        /*for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }*/

        //从最后一个节点开始向下看，看是否有孩子，没有孩子则跳出，有则和孩子PK，当前节点小则下沉，最终成为一个大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        //首位进行交换位置（将最大的数放置到最后）
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        // O(n * logN)

        //--heapsize仍然有值，则每次在heapsize-1的范围内迭代处理，位置互换后，当前节点开始往下看孩子节点，不断PK，下沉到正确的节点
        //每次放置一个最大值，次大值....最小值，即【min....max-2,max-1,max】
        while (heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = (index << 1) | 1; //求出左孩子的下标，计算公式 index * 2 + 1
        //左孩子是否越界
        while (left < heapSize) {
            //左右2个孩子PK,将大的孩子的index赋值给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父节点和最大的孩子进行PK
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) break;
            swap(arr, largest, index);
            index = largest;
            //继续寻找左孩子下标
            left = (index << 1) | 1;
        }

    }

    private static void swap(int[] arr, int largest, int index) {
        int tmp = arr[largest];
        arr[largest] = arr[index];
        arr[index] = tmp;
    }

    private static void heapInsert(int[] arr, int index) {
        //新插入节点和父节点PK，如果父节点干不过孩子，则下沉
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2; //更新当前节点下标
        }

    }

    public static void compartor(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) return null;

        int[] res = new int[arr.length];
        for (int i = 0;i<arr.length;i++){
            res[i] = arr[i];
        }

        return res;
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 == null && arr2 !=null) || (arr1 !=null && arr2 == null)){ return false;}
        if (arr1 == null && arr2 == null) return true;
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
       /* PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(5);
        heap.add(5);
        heap.add(1);
        heap.add(3);
        heap.add(7);
        heap.add(2);

        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }*/

        int testTimes = 1;
        int maxSize =10;
        int maxValue =100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);

            heapSort(arr1);
            compartor(arr2);

            if (!isEqual(arr1,arr2)){
               /* printArray(arr1);
                System.out.println("-----------------");
                printArray(arr2);*/
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "nice" : "Oops,Failed");
      /*  int[] arr = generateRandomArray(maxSize,maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);*/


    }
}
