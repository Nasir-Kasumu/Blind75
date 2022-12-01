package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<Integer,ArrayList<Integer>>();
        boolean [] visited = new boolean [n];
        int count  = 0;
        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            adj.put(i,temp);
        }

        for(int i = 0; i < edges.length; i++){
            int root = edges[i][0];
            int path = edges[i][1];
            if(adj.containsKey(root)){
                ArrayList<Integer> rootlist = adj.get(root);
                rootlist.add(path);
                adj.put(root,rootlist);
            }

            if(adj.containsKey(path)){
                ArrayList<Integer> pathlist = adj.get(path);
                pathlist.add(root);
                adj.put(path,pathlist);
            }
        }


        for(int i : adj.keySet()){
            //System.out.println(i + "->" + adj.get(i).toString());
        }

        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                dfs(adj,visited,i);
                count++;
            }
        }

        return count;
    }

    public void dfs(HashMap<Integer,ArrayList<Integer>> adj, boolean [] visited, int idx){
        visited[idx] = true;
        ArrayList<Integer> curr = adj.get(idx);
        for(int i = 0; i < curr.size(); i++){
            if(visited[curr.get(i)] == false){
                dfs(adj,visited,curr.get(i));
            }
        }
    }
}
