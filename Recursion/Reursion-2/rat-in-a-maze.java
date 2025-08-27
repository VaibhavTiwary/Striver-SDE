// Consider a rat placed at position (0, 0) in an n x n square matrix mat[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

// The matrix contains only two possible values:

// 0: A blocked cell through which the rat cannot travel.
// 1: A free cell that the rat can pass through.
// Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
// If no path exists, return an empty list.

// Note: Return the final result vector in lexicographically smallest order.

// Examples:

// Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
// Output: ["DDRDRR", "DRDDRR"]
// Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.

// User function Template for Java

class Solution {
    // Function to find all possible paths
    ArrayList <String> ans = new ArrayList<>();
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        
        int n = mat.size();
        int[][] visited = new int[n][n];
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        
        if(mat.get(0).get(0) == 1){
            solve(0, 0, mat, n, visited, di, dj, "");
        }
        return ans;
        
    }
    
    void solve(int i, int j, ArrayList<ArrayList<Integer>> mat, int n, int[][] visited, int[] di, int[] dj, String path){
        if(i == n-1 && j ==  n-1){
            ans.add(path);
            return;
        }
        
        String directions= "DLRU";
        // visited[i][j] = 1;
        
        for(int index = 0; index < 4; index++){
            int nexti = i + di[index];
            int nextj = j + dj[index];
            
            if(nexti >= 0 && nexti < n && nextj >= 0 && nextj < n && mat.get(nexti).get(nextj) == 1 && visited[nexti][nextj] == 0){
                visited[i][j] = 1;
                solve(nexti, nextj, mat, n, visited, di, dj, path + directions.charAt(index));
                visited[i][j] = 0;
            }
        }
    }
}