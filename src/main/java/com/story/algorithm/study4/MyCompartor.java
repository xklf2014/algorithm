package com.story.algorithm.study4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MyCompartor {

    public static class Student {
        private String name;
        private int age;
        private int id;

        public Student() {
        }

        public Student(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
        }
    }

    public static class IdAscendingCompartor implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }


    public static class IdDescendingCompartor implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static class AgeAscendingCompartor implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static class AgeDescendingCompartor implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static class AgeAscAndIdAsc implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age != o2.age ? (o1.age - o2.age) : (o1.id - o2.id);
        }
    }

    public static class IdAscAndAgeDesc implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id != o2.id ? (o1.id - o2.id) : (o2.age - o1.age);
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void printArray(Integer[] arr) {
        if (arr == null) return;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static class DescCom implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static class AscCom implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static void main(String[] args) {
     /*
        基本数据类型比较
        Integer[] arr = {5,4,3,2,1,9,8,7,6};
        Arrays.sort(arr,new AscCom());
        printArray(arr);
        Arrays.sort(arr,new DescCom());
        printArray(arr);*/

        /*Student s1 = new Student("Student1",20,1);
        Student s2 = new Student("Student2",30,2);
        Student s3 = new Student("Student3",10,3);

        Student[] students = new Student[]{s1,s2,s3};

        Arrays.sort(students,new IdAscendingCompartor());
        printStudents(students);
        Arrays.sort(students,new IdDescendingCompartor());
        printStudents(students);*/

        /*Student s1 = new Student("Student1",20,1);
        Student s2 = new Student("Student2",30,2);
        Student s3 = new Student("Student3",10,3);
        Student s4 = new Student("Student3",10,1);
        Student s5 = new Student("Student3",10,2);

        Student[] students = new Student[]{s1,s2,s3,s4,s5};
        Arrays.sort(students,new IdAscAndAgeDesc());
        printStudents(students);
        System.out.println("=====================");
        Arrays.sort(students,new AgeAscAndIdAsc());
        printStudents(students);*/

        /*PriorityQueue<Student> minHeapBasedId = new PriorityQueue<>(new IdAscendingCompartor());
        Student s1 = new Student("Student1",20,3);
        Student s2 = new Student("Student2",30,2);
        Student s3 = new Student("Student3",10,1);
        minHeapBasedId.add(s1);
        minHeapBasedId.add(s2);
        minHeapBasedId.add(s3);

        while (!minHeapBasedId.isEmpty()){
            Student student = minHeapBasedId.poll();
            System.out.println(student.toString());
        }*/

        TreeSet<Student> treeSet = new TreeSet<>(new AgeAscendingCompartor());
        Student s1 = new Student("Student1", 20, 3);
        Student s2 = new Student("Student2", 30, 2);
        Student s3 = new Student("Student3", 10, 1);
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);

        Student studentFirst = treeSet.first();
        System.out.println(studentFirst.toString());

        Student studentLast = treeSet.last();
        System.out.println(studentLast.toString());


    }


}
