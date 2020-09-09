package com.story.algorithm.study10;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//并查集
public class UnionFind {
    public static class Node<V>{
        V value;

        public Node(V value) {
            this.value = value;
        }
    }

    public static class UnionSet<V>{
        public HashMap<V,Node<V>> nodes;
        public HashMap<Node<V>,Node<V>> parents;
        public HashMap<Node<V>,Integer> sizeMap;

        public UnionSet(List<V> values){
            for (V cur : values){
                Node<V> node = new Node<>(cur);
                nodes.put(cur,node);
                parents.put(node,node);
                sizeMap.put(node,1);
            }
        }

        //从当前节点开始找，一直找到最终的父节点，返回父节点
        public Node<V> findFather(Node<V> cur){
            Stack<Node<V>> path = new Stack<>();
            while( cur != parents.get(cur)){
                path.push(cur);
                cur = parents.get(cur);
            }

            while(!path.isEmpty()){
                parents.put(path.pop(),cur);
            }

            return cur;
        }

        public boolean isSameSet(V a,V b){
            if (!nodes.containsKey(a) || !nodes.containsKey(b))return false;
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }


        public void union(V a,V b){
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) return;

            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead){
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                Node<V> big = aSize >= bSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                parents.put(small,big);
                sizeMap.put(big, aSize + bSize);
                sizeMap.remove(small);
            }
        }
    }
}
