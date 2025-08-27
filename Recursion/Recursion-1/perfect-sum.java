// Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the
//  array whose sum is equal to the given target.


class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int[][] dp = new int[target+1][nums.length+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(nums, target, 0, dp);
    }
    
    int solve(int[] nums, int target, int start, int[][] dp){
    // We only check target == 0 after we have processed the whole array.
    // So if target == 0 before finishing the array, 
    // we don’t immediately return — instead, we still explore the rest of the 
    // array because zeros might give additional valid subsets.
        if (start == nums.length) {
            return (target == 0) ? 1 : 0;
        }
        
        if(dp[target][start] != -1) return dp[target][start];

        
        int notPick = solve(nums, target, start+1, dp);
        
        int pick = 0;
        if(nums[start] == 0){
            // zero can be picked without reducing target
            pick = solve(nums, target, start + 1, dp);
        } else if(nums[start] <= target){
            pick = solve(nums, target - nums[start], start + 1, dp);
        }
        
        return dp[target][start] = pick + notPick;
        
        
    }
}