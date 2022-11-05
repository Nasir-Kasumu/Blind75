package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
// build adj list
// if the number of edges is >= number of nodes it cant be a tree
// use kahns algorithm to prune leaves
// go through adj list again if there is a list left with a size greater than 0 return false
public class GraphValidTree {
    public static Boolean checkGraph(int[][] edges, int n, int m) {
        HashMap<Integer, ArrayList<Integer>> map = buildMap(edges, n);
        Queue<Integer> q = new LinkedList<>();
        if(m >= n){
            return false;
        }
        for(int x : map.keySet()){
            if(map.get(x).size() == 0){
                q.add(x);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int x : map.keySet()){
                ArrayList<Integer> list = map.get(x);
                if(list.contains(Integer.valueOf(curr))){
                    list.remove(Integer.valueOf(curr));
                    if(list.size() == 0){
                        q.add(x);
                    }
                    map.put(x,list);
                }
            }
        }
        for(int x: map.keySet()){
            if(map.get(x).size() > 0){
                return false;
            }
        }
        return true;
    }

    public static HashMap<Integer,ArrayList<Integer>> buildMap(int [] [] edges, int n){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            map.put(i,temp);
        }
        for(int i = 0; i < edges.length; i++){
            int [] curr = edges[i];
            ArrayList<Integer> list = map.get(curr[0]);
            list.add(curr[1]);
            map.put(curr[0],list);
        }
        return map;
    }
}
