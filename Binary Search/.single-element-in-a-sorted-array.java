// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

 

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2

// The first occurrence of each pair is at even indices (0, 2, 4...) before the single element.

// After the single element, this pattern breaks — the first occurrence moves to odd indices.

// 👉 We always want mid to be even, so we can compare the pair: nums[mid] and nums[mid + 1].

// For example:

// If mid = 3, and we check nums[3] vs nums[4], it's not a pair.

// So we make mid = 2 so we can check a proper pair.
// int[] nums = {1,1,2,2,3,4,4,5,5};
// mid = (0 + 8)/2 = 4
// mid is even → no change

// nums[mid] = 3
// nums[mid + 1] = 4

// 3 != 4 → single is on left including mid
// → right = mid = 4

// 2nd iteration- left = 0, right = 4
// mid = (0 + 4)/2 = 2
// nums[mid] = 2
// nums[mid + 1] = 2 → equal → go right

// → left = mid + 2 = 4



class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(right > left){
            int mid = left + (right - left) / 2;

            if(mid % 2 == 1){
                mid--;
            }
            if(nums[mid] != nums[mid + 1]){
                right = mid;
            }
            else left = mid + 2;
        }
        return nums[left];
    }
}