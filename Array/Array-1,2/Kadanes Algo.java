// Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.


class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);

            if(sum < 0) sum = 0;
        // A negative sum will only reduce the total of any future subarray.
        // So it's better to start a new subarray from the next index.
        // This helps the algorithm skip over subarrays that hurt the overall result.

        }
        return maxSum;
    }
}