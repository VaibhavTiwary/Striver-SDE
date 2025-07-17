class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> paths = new ArrayList<>();
        
        solve(ans, paths, root);
        return ans;
        
    }
    
    static void solve(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> paths, Node root){
        
        if(root == null) return;
        
        paths.add(root.data);
        
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(paths));
            paths.remove(paths.size() - 1);
            return;
        }
        
        solve(ans, paths, root.left);
        solve(ans, paths, root.right);
        paths.remove(paths.size() - 1);
        
        
    }
}   