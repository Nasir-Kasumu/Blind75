package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
things to remember
think of it like sinking the island into the ocean bottom up approach
use a prev pointer in dfs to keep track
if for uses heights.length the dfs uses heights[0].length & vice versa
boolean array overlapping oceans dfs
*/
public class PacificAtlanticWaterflow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean [] [] pacific = new boolean [heights.length] [heights[0].length];
        boolean [] [] atlantic = new boolean [heights.length] [heights[0].length];

        for(int i = 0; i < heights.length; i++){ // down
            dfs(heights,pacific,-99,i,0);
            dfs(heights,atlantic,-99,i,heights[0].length-1);
        }

        for(int i = 0; i < heights[0].length; i++){ // across
            dfs(heights,pacific,-99,0,i);
            dfs(heights,atlantic,-99,heights.length-1,i);
        }

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ArrayList<Integer> temp = new ArrayList<>();
                    Collections.addAll(temp,i,j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public void dfs(int [] [] heights, boolean [] [] ocean, int prev, int r, int c){
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || ocean[r][c] == true || prev > heights[r][c]){
            return;
        }

        ocean[r][c] = true;
        prev = heights[r][c];

        dfs(heights,ocean,prev,r + 1, c);
        dfs(heights,ocean,prev,r - 1, c);
        dfs(heights,ocean,prev,r, c + 1);
        dfs(heights,ocean,prev,r, c - 1);
    }
}
