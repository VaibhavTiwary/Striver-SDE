public class Solution{
    public int islands(char[][] grid){

        int count = 0;

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    dfs(i, j, vis, grid);
                }
            }
        }

        return count;
        

    }

    public void dfs(int row, int col, boolean[] vis, char[][] grid){

        vis[row][col] = true;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !vis[nrow][ncol] && grid[nrow][ncol]){
                dfs(nrow, ncol, vis, grid);
            }
        }

    }