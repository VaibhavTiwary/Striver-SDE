// Given an integer array nums, return the length of the longest strictly increasing subsequence.

 

// Example 1:

// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

//Recursive
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        return solve(0, -1, nums);
    }

    int solve(int cur, int prev, int[] nums){
        if(cur == nums.length){
            return 0;
        }

        int notPick = solve(cur + 1, prev, nums);

        int pick = 0;
        if(prev == -1 || nums[cur] > nums[prev]){
            pick = 1 + solve(cur + 1, cur, nums);
        }

        return Math.max(pick, notPick);
        
    }
}
//Memoization - O(n^2)
// dp[cur][prev+1] = The length of the longest increasing subsequence starting at index cur, 
// assuming the last picked element was at index prev.

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(0, -1, nums, dp);
    }

    int solve(int cur, int prev, int[] nums, int[][] dp){
        if(cur == nums.length){
            return 0;
        }

        if(dp[cur][prev+1] != -1){
            return dp[cur][prev+1];
        }

        int notPick = solve(cur + 1, prev, nums, dp);

        int pick = 0;
        if(prev == -1 || nums[cur] > nums[prev]){
            pick = 1 + solve(cur + 1, cur, nums, dp);
        }

        return dp[cur][prev + 1] = Math.max(pick, notPick);
        
    }
}

//bottom-up O(n^2)
// dp[i] stores the max length of LIS that ends at nums[i].

class Solution {

    int maxLen = 1;
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        return solve(nums, dp);
    }

    int solve(int[] nums, int[] dp){

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;

    }
}