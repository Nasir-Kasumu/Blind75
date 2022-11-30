package Graphs;

public class NumberOfIslands {
    /*
3:22
dfs // finding all possibilities deep
iterative(stack)

recursive(call stack)*
    base case if out of bounds or not == 1
    mark chars in grid as visited as i go through them
    each dfs call update a count
    return a count var at end
    O(n) solution

bfs // if trying to find shortest path
iterative (queue)
recursive (queue)

O(n)
*/
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        dfs(grid,i,j);
                    }
                }
            }
            return count;
        }

        public void dfs(char [] [] grid, int r, int c){
            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1'){
                return;
            }

            grid[r][c] = '*';

            dfs(grid,r + 1,c);
            dfs(grid,r - 1,c);
            dfs(grid,r,c + 1);
            dfs(grid,r,c - 1);
        }
    }
}
