// Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 

// Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.

// Examples :

// Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
// Output: 3
// Explanation: Choose the last item, which weighs 1 unit and has a value of 3.


class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        
        int[][] dp = new int[W+1][n+1];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
            
        }
        return solve(W, val, wt, n-1, dp);
    }
    
    static int solve(int W, int[] val, int[] wt, int start, int[][] dp){
        
        if(start < 0) return 0;
        
        if(dp[W][start] != -1) return dp[W][start];
        
        int notpick = solve(W, val, wt, start-1, dp);
        int pick = 0;
        if(W >= wt[start]){
            pick = val[start] + solve(W - wt[start], val, wt, start-1, dp);
        }
        return dp[W][start] = Math.max(pick, notpick);
    }
}
