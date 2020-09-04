package com.story.algorithm.study9;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    public static int findMaximizedCapital(int K,int W,int[] profits,int[] capital){
        PriorityQueue<Program> minCostQ =new PriorityQueue<>(new MinCostCompartor());
        PriorityQueue<Program> maxProfitQ =new PriorityQueue<>(new MaxProfitComparator());

        for (int i = 0; i < profits.length; i++) {
            minCostQ.add(new Program(profits[i],capital[i]));
        }
        for (int i = 0; i < K; i++) {
            while(!minCostQ.isEmpty() && minCostQ.peek().c <= W){
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()){
                return W;
            }
            W+=maxProfitQ.poll().p;
        }
        return W;
    }

    public static class Program{
        public int p;
        public int c;

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostCompartor implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o2.p - o1.p;
        }
    }

    public static Program[] generatePrograms(int programSize, int maxP,int maxC){
        Program[] ans  = new Program[(int)(Math.random() * programSize)];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new Program((int)(Math.random() * maxP),(int)(Math.random() * maxC));
        }
        return ans;

    }

    public static void main(String[] args) {
        int maxP = 10;
        int maxC = 20;
        int programSize = 5;
        int testTimes = 1;
        for (int i = 0; i <testTimes ; i++) {
            Program[] ans = generatePrograms(programSize, maxP, maxC);
            int[] profits = new int[ans.length];
            int[] capital = new int[ans.length];
            for (int j = 0 ;j<ans.length;j++){
                profits[j] = ans[j].p;
                capital[j] = ans[j].c;
            }
            int maximizedCapital = findMaximizedCapital(5,5,profits,capital);
            System.out.println(maximizedCapital);
        }
    }
}
