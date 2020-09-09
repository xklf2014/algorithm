package com.story.algorithm.study10;

import java.util.*;

//拓扑排序
public class TopologySort {
    //有向图且无环
    public static List<Node> sortedTopology(Graph graph){
        //key为某一个node，value为剩余的入度
        HashMap<Node,Integer> inMap = new HashMap<>();
        //剩余入度为0时方可进入此队列
        Queue<Node> zeroInQueue = new LinkedList<>();

        for (Node node : graph.nodes.values()){
            inMap.put(node,node.in);
            if (node.in == 0){
                zeroInQueue.add(node);
            }
        }

        //拓扑排序结果依次加入到result
        List<Node> result = new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            Node cur= zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts){
                inMap.put(next,inMap.get(next)-1);
                if (inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        Edge e1 = new Edge(10,n1,n2);
        Edge e2 = new Edge(2,n1,n3);
        Edge e3 = new Edge(3,n1,n4);
        Edge e4 = new Edge(5,n2,n5);
        Edge e5 = new Edge(2,n3,n2);
        Edge e6 = new Edge(7,n3,n5);
        Edge e7 = new Edge(4,n4,n3);

        HashMap<Integer, Node> hashMap = new HashMap<>();
        hashMap.put(1,n1);
        hashMap.put(2,n2);
        hashMap.put(3,n3);
        hashMap.put(4,n4);
        hashMap.put(5,n5);
        HashSet set = new HashSet();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.add(e6);
        set.add(e7);

        Graph graph = new Graph(hashMap,set);
        sortedTopology(graph).forEach(r->{
            System.out.println(r);
        });




    }
}
