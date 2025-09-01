// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = helper(coins, 0, amount);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
    
    private int helper(int[] coins, int index, int amount) {
        if (amount == 0) return 0;          // exact amount reached
        if (index == coins.length) return Integer.MAX_VALUE; // no coins left
        
        // PICK the coin (if possible)
        int pick = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int res = helper(coins, index, amount - coins[index]);
            if (res != Integer.MAX_VALUE) pick = 1 + res;
        }
        
        // NOT PICK the coin
        int notPick = helper(coins, index + 1, amount);
        
        return Math.min(pick, notPick);
    }
}

//Memoization
// dp[index][amount] = The minimum number of coins needed to make amount using coins from index to the end of the array
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        // initialize memo table with -1
        for (int[] row : dp) Arrays.fill(row, -1);
        
        int ans = helper(coins, 0, amount, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
    
    private int helper(int[] coins, int index, int amount, int[][] dp) {
        if (amount == 0) return 0;
        if (index == coins.length) return Integer.MAX_VALUE;
        
        if (dp[index][amount] != -1) return dp[index][amount];
        
        // PICK the coin
        int pick = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int res = helper(coins, index, amount - coins[index], dp);
            if (res != Integer.MAX_VALUE) pick = 1 + res;
        }
        // -res is result of recursive call
        // It returns Integer.MAX_VALUE if it’s impossible to make amount - coins[index] using the     remaining coins.
        // So the check avoids overflow and ensures we only count valid solutions.
        
        // NOT PICK the coin
        int notPick = helper(coins, index + 1, amount, dp);
        
        return dp[index][amount] = Math.min(pick, notPick);
    }
}

