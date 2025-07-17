class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Height(root) == -1) return false;
        return true;
    }
    private int Height (TreeNode root){
        if(root == null) return 0;
        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);
        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight , rightHeight) + 1;
    }
}

//For each node checking if it is balanced


//...............if(leftHeight == -1 || rightHeight == -1) return -1;
// You use -1 as a special flag to indicate:
// ❌ “This subtree is not balanced.”

// When you call Height(root.left) and Height(root.right), you might get -1 if either subtree is already unbalanced.

// So:

// if (leftHeight == -1 || rightHeight == -1)
// This checks:

// “Has any child subtree already been marked as unbalanced?”