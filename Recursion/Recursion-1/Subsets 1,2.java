// Given an integer array nums of unique elements, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        solve(nums, 0, newList, list);
        return list;
    }

    public void solve(int[] nums, int index, List<Integer>newList, List<List<Integer>> list){
        if(index == nums.length){
            list.add(new ArrayList<>(newList));
            return;
        }
        
        newList.add(nums[index]);
        solve(nums, index+1, newList, list);
        newList.remove(newList.size()-1);
        solve(nums, index+1, newList, list);
    }
}

//no duplicates
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subsets = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, ans, subsets, 0);
        return ans;
    }

    void solve(int[] nums, List<List<Integer>> ans, List<Integer> subsets, int start){

        ans.add(new ArrayList<>(subsets));   // add every time we enter recursion
        
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;

            subsets.add(nums[i]);
            solve(nums, ans, subsets, i+1);
            subsets.remove(subsets.size()-1);
        }
    }
}