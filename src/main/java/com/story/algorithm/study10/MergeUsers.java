package com.story.algorithm.study10;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MergeUsers {
    public static class Node<V> {
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> values) {
            for (V cur : values) {
                Node<V> node = new Node<>(cur);
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> cur) {
            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }

            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(V v1 ,V v2 ){
            if (!nodes.containsKey(v1) || !nodes.containsKey(v2)) return false;

            return findFather(nodes.get(v1)) == findFather(nodes.get(v2));
        }

        public void union(V v1,V v2){
            if (!nodes.containsKey(v1) || !nodes.containsKey(v2))return;

            Node v1Head = findFather(nodes.get(v1));
            Node v2Head = findFather(nodes.get(v2));
            if (v1Head != v2Head){
                int v1SetSize = sizeMap.get(v1Head);
                int v2SetSize = sizeMap.get(v2Head);
                Node<V> big = v1SetSize >=  v2SetSize ? v1Head : v2Head;
                Node<V> small = big == v1Head ? v2Head : v1Head;
                parents.put(small,big);
                sizeMap.put(big, v1SetSize + v2SetSize);
                sizeMap.remove(small);
            }
        }

        public int getSetNum(){
            return sizeMap.size();
        }
    }

    public static class User{
        public String a;
        public String b;
        public String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    // (1,10,13) (2,10,37) (400,500,37)
    // 如果两个user，a字段一样、或者b字段一样、或者c字段一样，就认为是一个人
    // 请合并users，返回合并之后的用户数量
    public static int mergeUsers(List<User> users){
        UnionSet<User> unionFind = new UnionSet<>(users);
        HashMap<String,User> mapA = new HashMap<>();
        HashMap<String,User> mapB = new HashMap<>();
        HashMap<String,User> mapC = new HashMap<>();
        for (User user : users){
            if (mapA.containsKey(user.a)){
                unionFind.union(user,mapA.get(user.a));
            }else{
                mapA.put(user.a,user);
            }

            if (mapB.containsKey(user.b)){
                unionFind.union(user,mapB.get(user.b));
            }else{
                mapB.put(user.b,user);
            }

            if (mapC.containsKey(user.c)){
                unionFind.union(user,mapC.get(user.c));
            }else{
                mapC.put(user.c,user);
            }
        }
        //从并查集中取出集合数量
        return unionFind.getSetNum();

    }
}
