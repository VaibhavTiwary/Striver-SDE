public class Solution{
    public int islands(char[][] grid){

        int m = grid.length;
        int n = grid[0].length;
        boolean[] vis = new boolean[m][n];

        int count = 0;

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
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !vis[nrow][ncol]){
                dfs(nrow, ncol, vis, grid);
            }
        }


    }
}