package Pramp;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestCellPath {
    static int min = Integer.MAX_VALUE;

    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        //boolean [] [] visited = new boolean [grid.length][grid[0].length];
        //min = Integer.MAX_VALUE;
        //dfs(grid,sr,sc,tr,tc,visited,0);

        return bfs(grid,sr,sc,tr,tc);
    }

    //dfs approach using global min
    //due to the way pramps tests work min needs to be updated on line 11 if using recursion + global vairable
    public static void dfs(int [] [] grid, int sr, int sc, int tr, int tc, boolean [] [] visited, int count){
        if(sr >= grid.length || sc >= grid[0].length || sc < 0 || sr < 0 || grid[sr][sc] == 0 || visited[sr][sc] == true){
            return;
        }

        visited[sr][sc] = true;

        if(sr == tr && sc == tc && count < min){
            min = count;
        }

        dfs(grid,sr + 1, sc,tr,tc,visited,count + 1);
        dfs(grid,sr - 1, sc,tr,tc,visited,count + 1);
        dfs(grid,sr, sc + 1,tr,tc,visited,count + 1);
        dfs(grid,sr, sc - 1,tr,tc,visited,count + 1);

        //visited[sr][sc] = false;
    }

    static int bfs(int [] [] grid, int sr, int sc, int tr, int tc){//bfs approach
        Queue<int[]> q = new LinkedList<>();
        int [] temp = new int [] {sr,sc,0};
        int [] curr;
        q.add(temp);

        while(!q.isEmpty()){
            curr = q.poll();
            int [] t;
            sr = curr[0];
            sc = curr[1];
            grid[curr[0]][curr[1]] = 99;
            if(curr[0] == tr && curr[1] == tc){
                return curr[2];
            }
            if(sr - 1 >= 0 && grid[sr - 1][sc] == 1){
                t = new int [] {sr - 1, sc, curr[2] + 1};
                q.add(t);
            }
            if(sc - 1 >= 0 && grid[sr][sc - 1] == 1){
                t = new int [] {sr, sc - 1, curr[2] + 1};
                q.add(t);
            }
            if(sr + 1 < grid.length && grid[sr + 1][sc] == 1){
                t = new int [] {sr + 1, sc, curr[2] + 1};
                q.add(t);
            }
            if(sc + 1 < grid[0].length && grid[sr][sc + 1] == 1){
                t = new int [] {sr, sc + 1, curr[2] + 1};
                q.add(t);
            }
        }


        return -1;
    }
}
