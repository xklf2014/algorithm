package com.story.algorithm.study7;

public class PaperFolding {

    public static void printAllFolds(int N){
        printProcess(1,N,true);
    }

    //i是节点层数，N是一共几层，down=true 凹 down=false 凸
    private static void printProcess(int i, int N, boolean down) {
        if (i > N){
            return;
        }

        printProcess(i+1,N,true);
        System.out.println( down ? "凹":"凸");
        printProcess(i+1,N,false);
    }

    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }
}
