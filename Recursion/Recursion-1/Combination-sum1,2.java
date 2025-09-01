// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        solve(ans, combinations, candidates, target, 0);
        return ans;
    }

    void solve(List<List<Integer>> ans, List<Integer> combinations, int[] candidates, int target, int start){
        if(target == 0){
            ans.add(new ArrayList<>(combinations));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(target >= candidates[i]){
                combinations.add(candidates[i]);
                solve(ans, combinations, candidates, target - candidates[i], i);
                combinations.remove(combinations.size()-1);
            }
        }
    }
}

// ex: nums = [2,3,6,7], target = 7
// Path goes: [2] → [2,2] → [2,2,2], now target=1
// 1 < 2 so if-block not entered, loop continues but skips all (3,6,7)
// No candidates → loop ends → call returns to parent
// Parent then does path.remove(...) → backtracks → path becomes [2,2]



//COmbination-sum 2
//Note: The solution set must not contain duplicate combinations.

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, candidates, target, temp, ans);
        return ans;
    }

      private void solve(int index, int[] candidates, int target, List<Integer> temp, List<List<Integer>> ans) {

        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if(candidates[i] <=  target){
                temp.add(candidates[i]);
                solve(i + 1, candidates, target - candidates[i], temp, ans);
                temp.remove(temp.size() - 1); // Backtrack
            } 
        }
    }
}
