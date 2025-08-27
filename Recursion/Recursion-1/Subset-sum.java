// Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum 
// equal to given sum. 


//Memoization
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        
        return solve(arr, sum, dp, 0);
    }
    
    static boolean solve(int[] arr, int target, Boolean[][] dp, int idx){
        if(target == 0) return true;
        if(idx >= arr.length) return false;
        
        if(dp[idx][target] != null) return dp[idx][target];
        
        boolean notpick = solve(arr, target, dp, idx+1);
        
        boolean pick = false;
        if(target >= arr[idx]){
            pick = solve(arr, target - arr[idx], dp, idx + 1);
        }
        
        return dp[idx][target] = pick || notpick;
    }
}

//Bottom-UP

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        
        boolean[][] dp = new boolean[n+1][sum+1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // for(int i = 1; i <= sum; i++){
        //     dp[0][i] = false;
        // }
        
        for(int i = 1; i <= n; i++){
            for(int target = 1; target <= sum; target++){
                boolean notPick = dp[i-1][target];
                 
                boolean pick = false;
                if(arr[i-1] <= target){
                    pick = dp[i-1][target-arr[i-1]];
                }
                 
                dp[i][target] = pick || notPick;

            }
        }
        return dp[n][sum];
    }
}