package Graphs;
/*
add 0 if directly touching 4 islands
add 3 if directly touching 1 island
add 2 if directly touching 2 islands
add 4 if directly touching no islands
add 1 if directly touching 3 islands

care for edges?


*/
public class IslandPerimeter {
    int sum = 0;
    public int islandPerimeter(int[][] grid) {
        boolean [] [] visited = new boolean[grid.length][grid[0].length];
        dfs(grid,visited,0,0);
        return sum;
    }

    public void dfs(int [] [] grid, boolean [] [] visited, int r, int c){
        if(r < 0 || c < 0 || r > grid.length - 1 || c > grid[0].length - 1 || visited[r][c] == true){
            return;
        }

        visited[r][c] = true;
        if(grid[r][c] == 1){
            sum += tileCalculator(grid,r,c);
        }

        dfs(grid,visited,r + 1, c);
        dfs(grid,visited,r - 1, c);
        dfs(grid,visited,r, c + 1);
        dfs(grid,visited,r, c - 1);
    }

    public int tileCalculator(int [] [] grid, int r, int c){
        int res = 0;
        if(r > 0 && grid[r - 1][c] == 0){ // left
            res += 1;
        }else if(r == 0){
            res += 1; // or +2?
        }

        if(r < grid.length - 1 && grid[r + 1][c] == 0){// right
            res += 1;
        }else if(r == grid.length - 1){
            res += 1;
        }

        if(c > 0 && grid[r][c - 1] == 0){ // up
            res += 1;
        }else if(c == 0){
            res += 1;
        }

        if(c < grid[0].length - 1 && grid[r][c + 1] == 0){
            res += 1;
        }else if(c == grid[0].length - 1){
            res += 1;
        }

        return res;
    }
}
