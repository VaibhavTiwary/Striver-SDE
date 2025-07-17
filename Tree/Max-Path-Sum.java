// Given the root of a binary tree, return the maximum path sum of any non-empty path.

class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }

    int solve(TreeNode root){

        if(root == null) return 0;
    

        int lsum = Math.max(solve(root.left), 0);  //we would always take 0 if left subtree is returning -ve sum.
        int rsum = Math.max(solve(root.right), 0);

        ans = Math.max(ans, lsum + rsum + root.val);
        return Math.max(lsum, rsum) + root.val;
    }
}