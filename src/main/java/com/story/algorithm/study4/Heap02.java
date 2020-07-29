package com.story.algorithm.study4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Heap02 {

    public static class MyHeap<T> {
        private ArrayList<T> heap;
        private HashMap<T, Integer> indexMap;
        private int heapSize;
        private Comparator<? super T> comparator;

        public MyHeap(Comparator<? super T> com) {
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            this.comparator = com;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public int size() {
            return heapSize;
        }

        public boolean contains(T key) {
            return indexMap.containsKey(key);
        }

        public void push(T value) {
            heap.add(value);
            indexMap.put(value, heapSize);
            heapInsert(heapSize++);
        }

        public T pop() {
            T ans = heap.get(0);
            int end = heapSize - 1;
            swap(0, end);
            heap.remove(end);
            indexMap.remove(ans);
            heapify(0, --heapSize);

            return ans;

        }

        private void heapify(int index, int heapSize) {
            int left = (index << 1) | 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize && (comparator.compare(heap.get(left + 1), heap.get(left))) < 0
                        ? left + 1
                        : left;

                largest = comparator.compare(heap.get(largest),heap.get(index)) < 0 ? largest : index;
                if (largest == index){
                    break;
                }

                swap(largest,index);
                index = largest;
                left = (index << 1) | 1;
            }
        }

        public void resign(T value){
            int valueIndex = indexMap.get(value);
            heapInsert(valueIndex);
            heapify(valueIndex,heapSize);

        }

        private void heapInsert(int idx) {
            while (comparator.compare(heap.get(idx), heap.get((idx - 1) / 2)) < 0) {
                swap(idx, (idx - 1) / 2);
                idx = (idx - 1) / 2;
            }
            ;
        }

        private void swap(int i, int j) {
            T o1 = heap.get(i);
            T o2 = heap.get(j);
            heap.set(i, o2);
            heap.set(j, o1);
            indexMap.put(o1, j);
            indexMap.put(o2, i);

        }
    }

    public static class Student{
        private int classNo;
        private int age;

        public Student() {
        }

        public Student(int classNo, int age) {
            this.classNo = classNo;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "classNo=" + classNo +
                    ", age=" + age +
                    '}';
        }
    }

    public static class StudentCompartor implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }


    public static void main(String[] args) {
       /* Student s1 = null;
        Student s2 = null;
        Student s3 = null;
        Student s4 = null;
        Student s5 = null;
        Student s6 = null;

        s1 = new Student(1,15);
        s2 = new Student(1,16);
        s3 = new Student(1,14);
        s4 = new Student(2,13);
        s5 = new Student(2,14);
        s6 = new Student(2,15);

        PriorityQueue<Student> students = new PriorityQueue<>(new StudentCompartor());
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        while (!students.isEmpty()){
            Student s = students.poll();
            System.out.println(s.toString());
        }

        System.out.println("===========================");

        MyHeap<Student> myHeap = new MyHeap<>(new StudentCompartor());
        myHeap.push(s1);
        myHeap.push(s2);
        myHeap.push(s3);
        myHeap.push(s4);
        myHeap.push(s5);
        myHeap.push(s6);

        while (!myHeap.isEmpty()){
            Student s = myHeap.pop();
            System.out.println(s.toString());
        }
        System.out.println("=========================");


        s1 = new Student(1,15);
        s2 = new Student(1,16);
        s3 = new Student(1,14);
        s4 = new Student(2,13);
        s5 = new Student(2,14);
        s6 = new Student(2,15);
        myHeap = new MyHeap<>(new StudentCompartor());
        myHeap.push(s1);
        myHeap.push(s2);
        myHeap.push(s3);
        myHeap.push(s4);
        myHeap.push(s5);
        myHeap.push(s6);

        s2.age = 5;
        myHeap.resign(s2);
        while (!myHeap.isEmpty()){
            Student s = myHeap.pop();
            System.out.println(s.toString());
        }*/


       //对数器
        int maxValue = 100;
        int pushTime = 100;
        int resignTime = 100;

        MyHeap<Student> myHeap = new MyHeap<>(new StudentCompartor());
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < pushTime;i++){
            Student curStu =new Student(1,(int)(Math.random() * maxValue));
            list.add(curStu);
            myHeap.push(curStu);
        }

        for (int i = 0; i < resignTime; i++) {
            int index = (int)(Math.random() * pushTime);
            list.get(index).age = (int)(Math.random() * maxValue);
            myHeap.resign(list.get(index));
        }

        int preAge =Integer.MIN_VALUE;
        while (!myHeap.isEmpty()){
            Student student = myHeap.pop();
            System.out.println(student.age);
            if (student.age < preAge){
                System.out.println("Oops");
            }
            preAge = student.age;
        }

        System.out.println("test finshed");


    }


}
