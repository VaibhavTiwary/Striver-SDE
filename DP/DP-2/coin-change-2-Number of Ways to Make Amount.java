// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

// The answer is guaranteed to fit into a signed 32-bit integer.

 

// Example 1:

// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1


// dp[index][target] = number of ways to make target using coins from index index to n-1

class Solution {
    public int change(int amount, int[] coins) {
        
        int n = coins.length;

        int[][] dp = new int[n+1][amount+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(amount, coins, 0, dp);
    }

    int solve(int amount, int[] coins, int start, int[][] dp){
        if(amount == 0) return 1;
        if(start >= coins.length) return 0;

        if(dp[start][amount] != -1) return dp[start][amount];

        int notPick = solve(amount, coins, start + 1, dp);

        int pick = 0;
        if(coins[start] <= amount){
            pick = solve(amount - coins[start], coins, start, dp);
        }

        return dp[start][amount] = pick + notPick;
    }
}

//Bottom-up
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n + 1][amount + 1];
        
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        // for(int j = 1; j <= amount; j++) {
        //     dp[0][j] = 0;
        // }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                int notPick = dp[i-1][j];

                int pick = 0;
                if(coins[i-1] <= j){
                    pick = dp[i][j - coins[i - 1]];
                }
                
                dp[i][j] = pick + notPick;
            }
        }
        
        return dp[n][amount];
    }
}