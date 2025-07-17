// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.


// You used post-order traversal to get the height of each node.

// At each node, lh + rh gives you the longest path through that node.

// ans keeps track of the maximum such path found so far.


class Solution {
    int ans = 0;

    public int height(TreeNode root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        
        ans = Math.max(ans, lh + rh);
        
        return Math.max(lh, rh) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }
}
