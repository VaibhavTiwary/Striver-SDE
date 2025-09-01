// Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

// For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

// The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

// Return the vertical order traversal of the binary tree.

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[9],[3,15],[20],[7]]
// Explanation:
// Column -1: Only node 9 is in this column.
// Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
// Column 1: Only node 20 is in this column.
// Column 2: Only node 7 is in this column.


//for each column, we need to have smaller row elements first and if there are multiple on same row then 
// sort the elements

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class rowData{
        int row;
        int val;
        rowData(int row, int val){
            this.row = row;
            this.val = val;
        }
    }
    class Pair{
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0, 0));

        TreeMap<Integer, List<rowData>> map = new TreeMap<>();

        while(!q.isEmpty()){
            Pair it = q.poll();
            TreeNode node = it.node;
            int row = it.row;
            int col = it.col;

            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(new rowData(row, node.val));

            if(node.left != null) q.add(new Pair(node.left, row + 1, col - 1));
            if(node.right != null) q.add(new Pair(node.right, row + 1, col + 1));

        }

        
        for(List<rowData> list : map.values()){
            list.sort((a,b) -> a.row == b.row ? a.val - b.val : a.row - b.row);

            List<Integer> temp = new ArrayList<>();
            for(rowData it : list){
                temp.add(it.val);
            }
            ans.add(temp);
        }
        return ans;

    }
}

// Tc- O(N) for BFS traversal
//  For Insertion in TreeMap- O(log C) per insertion in TreeMap → TreeMap is a balanced BST, and C = number of distinct columns (≤ N).
//   O(N) nodes * O(logC) per insertion = O(NlogC)
//For sorting column- o(n log n)

//TC Overall- O(N log N)