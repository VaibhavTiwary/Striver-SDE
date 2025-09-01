// Given the root of a binary tree, return the maximum width of the given tree.

// The maximum width of a tree is the maximum width among all levels.

// The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

// It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

// Example 1:


// Input: root = [1,3,2,5,3,null,9]
// Output: 4
// Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).


public class Pair {
    TreeNode root;
    int num;

    Pair(TreeNode root, int num) {
        this.root = root;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int first = 0, last = 0, res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int num = curr.num;

                if (i == 0) first = num;
                if (i == size-1) last = num;
                if (curr.root.left != null) {
                    q.offer(new Pair(curr.root.left, 2*num+1));
                }
                if (curr.root.right != null) {
                    q.offer(new Pair(curr.root.right, 2*num+2));
                }
            }
            res = Math.max(res, last-first+1);
        }
        return res;
    }
}