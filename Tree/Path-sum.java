// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the 
// values along the path equals targetSum.

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum, 0);
    }

    boolean solve(TreeNode root, int targetSum, int sum){

        if(root == null) return false;

        sum += root.val;

        if(root.left == null && root.right == null){
            if(sum == targetSum) return true;
            else return false;   
        }

        boolean lsum = solve(root.left, targetSum, sum);
        boolean rsum = solve(root.right, targetSum, sum);
        return lsum || rsum;
    }
}


//Path Sum 2
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();

        solve(root, targetSum, ans, paths, 0);
        return ans;
    }

    void solve(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> paths, int sum){
        if(root == null) return;

        sum += root.val;
        paths.add(root.val);

        if(root.left == null && root.right == null){

            if(sum == targetSum){
                ans.add(new ArrayList<>(paths));
            }
            paths.remove(paths.size() - 1);
            return;
        }

        solve(root.left, targetSum, ans, paths, sum);
        solve(root.right, targetSum, ans, paths, sum);
        paths.remove(paths.size()-1);
    }


}