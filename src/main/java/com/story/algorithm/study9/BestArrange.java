package com.story.algorithm.study9;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange1(Program[] programs) {
        if (programs == null || programs.length == 0) return 0;
        return process(programs, 0, 0);
    }

    /*
     *  剩余的项目都放在programs
     *   done之前已经安排了多少会议
     *   timeLine当前来到的时间点
     *
     *   目前来到timeLine，已经安排了done场会议，剩下的会议programs可以自由安排
     *   返回能安排的最多会议数量
     * */
    private static int process(Program[] programs, int done, int timeLine) {
        if (programs.length == 0) return done;
        //还有会议可以安排
        int max = done;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= timeLine) {
                Program[] next = copyButExcept(programs, i);
                max = Math.max(max,process(next,done+1,programs[i].end));
            }
        }
        return max;
    }

    private static Program[] copyButExcept(Program[] programs, int i) {
        Program[] ans = new Program[programs.length - 1];
        int index = 0;
        for (int j = 0; j < programs.length; j++) {
            if (j != i) {
                ans[index++] = programs[j];
            }
        }
        return ans;
    }

    public static int bestArrange2(Program[] programs){
        Arrays.sort(programs,new ProgramCompartor());
        int timeLine = 0;
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timeLine <= programs[i].start){
                result++;
                timeLine = programs[i].end;
            }
        }
        return result;
    }



    public static class ProgramCompartor implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static Program[] generatePrograms(int programSize,int timeMax){
        Program[] ans  = new Program[(int)(Math.random() * programSize)];
        for (int i = 0; i < ans.length; i++) {
            int r1 = (int) (Math.random() * (timeMax +1));
            int r2 = (int) (Math.random() * (timeMax +1));
            if (r1 == r2){
                ans[i] = new Program(r1,r1+1);
            }else{
                ans[i] = new Program(Math.min(r1,r2),Math.max(r1,r2));
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        int programSize = 10;
        int timeMax =20;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            Program[] ans = generatePrograms(programSize,timeMax);
            if (bestArrange1(ans) != bestArrange2(ans)){
                System.out.println("Oops");
            }
        }
        System.out.println("test finished");
    }
}
