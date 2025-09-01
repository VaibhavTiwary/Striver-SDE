// The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

// Example 1:

// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.


import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 from end to start
        for (int i = nums2.length - 1; i >= 0; i--) {
            int curr = nums2[i];

            // Pop elements from the stack which are smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            // If stack is empty, no next greater element
            int nextGreater = stack.isEmpty() ? -1 : stack.peek();

            // Map current number to its next greater
            nextGreaterMap.put(curr, nextGreater);

            // Push current element to stack
            stack.push(curr);
        }

        // Build the result for nums1 using the map
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreaterMap.get(nums1[i]);
        }

        return ans;
    }
}
