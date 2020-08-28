package com.story.algorithm.study8;

import java.util.ArrayList;
import java.util.List;

public class MaxHappy {
    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int happy) {
            this.happy = happy;
            this.nexts = new ArrayList<>();
        }
    }

    public static int maxHappy1(Employee boss) {
        if (boss == null) return 0;

        return process1(boss, false);
    }

    /*
     *   cur表示当前节点,up表示当前节点的上级是否来
     *      如果up为true，表示确定cur的上级来情况，cur整棵树最大的快乐值是多少
     *      如果up为false，表示确定cur的上级不来的情况，cur整棵树最大的快乐值是多少
     * */
    private static int process1(Employee cur, boolean up) {
        if (up) {
            int ans = 0;
            for (Employee next : cur.nexts) {
                ans += process1(next, false);
            }
            return ans;
        } else {
            //如果cur的上级不来的话，cur可以选，可以来也可以不来
            int p1 = cur.happy;
            int p2 = 0;
            for (Employee next : cur.nexts) {
                p1 += process1(next, true);
                p2 += process1(next, false);
            }
            return Math.max(p1, p2);
        }
    }

    public static int maxHappy2(Employee boss) {
        if (boss == null) return 0;

        Info all = process2(boss);
        return Math.max(all.yes, all.no);
    }

    private static Info process2(Employee X) {
        if (X.nexts.isEmpty()) {
            return new Info(X.happy, 0);
        }

        int yes = X.happy;
        int no = 0;
        for (Employee next : X.nexts) {
            Info nextInfo = process2(next);
            yes += nextInfo.no;
            no += Math.max(nextInfo.yes,nextInfo.no);
        }
        return new Info(yes,no);
    }

    public static class Info {
        public int yes;
        public int no;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

    public static Employee generateBoss(int maxLevel,int maxNexts,int maxHappy){
        if(Math.random() < 0.02){
            return null;
        }

        Employee boss = new Employee((int)(Math.random() * (maxHappy + 1)));
        generateNexts(boss,1,maxLevel,maxNexts,maxHappy);
        return boss;
    }

    private static void generateNexts(Employee boss, int level, int maxLevel, int maxNexts, int maxHappy) {
        if (level > maxLevel)return;

        int nextsSize = (int)(Math.random() * (maxNexts + 1));
        for (int i = 0; i < nextsSize; i++) {
            Employee next = new Employee((int)(Math.random() * (maxHappy + 1)));
            boss.nexts.add(next);
            generateNexts(next,level+1,maxLevel,maxNexts,maxHappy);
        }
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxNexts = 5;
        int maxHappy = 50;
        int testTimes = 1000;
        for (int i= 0;i<testTimes;i++){
            Employee boss = generateBoss(maxLevel, maxNexts, maxHappy);
            if (maxHappy1(boss) != maxHappy2(boss)){
                System.out.println("Oops");
            }
        }

        System.out.println("test finished");
    }
}
