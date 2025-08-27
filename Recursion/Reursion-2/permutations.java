// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


// Copying each permutation: O(n)
// Number of permutations: n!
// TC =𝑂(𝑛⋅𝑛!)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        solve(nums, ans, permutations, used);
        return ans;
    }

    void solve(int[] nums, List<List<Integer>> ans, List<Integer> permutations, boolean[] used) {
        if (permutations.size() == nums.length) {
            ans.add(new ArrayList<>(permutations));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            permutations.add(nums[i]);
            solve(nums, ans, permutations, used);
            used[i] = false;
            permutations.remove(permutations.size() - 1);
        }
    }
}