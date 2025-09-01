// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].


//Recursion
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        if(sum % 2 != 0) return false;
        else{
            return subsetSum(nums, sum/2, 0, dp);
        }
    }

    boolean subsetSum(int[] nums, int target, int index, boolean[][] dp){

        if(target == 0) return true;
        if(index == nums.length){
            return false;
        }

        if(dp[index][target] != false) return dp[index][target];

        boolean notPick = subsetSum(nums, target, index + 1, dp);

        boolean pick = false;
        if(target >= nums[index]){
            pick = subsetSum(nums, target - nums[index], index + 1, dp);
        }

        return dp[index][target] = pick || notPick;
    }

}

//Memoization
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        int target = sum / 2;
        Boolean[][] dp = new Boolean[n + 1][target + 1];

        if(sum % 2 != 0) return false;
        else{
            return subsetSum(nums, sum/2, 0, dp);
        }
    }

    boolean subsetSum(int[] nums, int target, int index, Boolean[][] dp){

        if(target == 0) return true;
        if(index == nums.length){
            return false;
        }

        if(dp[index][target] != null) return dp[index][target];

        boolean notPick = subsetSum(nums, target, index + 1, dp);

        boolean pick = false;
        if(target >= nums[index]){
            pick = subsetSum(nums, target - nums[index], index + 1, dp);
        }

        return dp[index][target] = pick || notPick;
    }

    


}