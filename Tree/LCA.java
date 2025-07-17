//BST
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } 
        
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root; 
    }
}

//Iterative BST
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root; // Found the split point or exact match
            }
        }
        return null; // In case one of the nodes isn't in the tree
    }
}



//BT
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return solve(root, p, q);
    }

    TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q) return root;

        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}