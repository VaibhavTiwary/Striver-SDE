class Solution {
    ArrayList<Integer> ans = new ArrayList<>();

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        dfss(0, vis, adj);  // Start DFS from node 0
        return ans;
    }

    void dfss(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        ans.add(node);

        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                dfss(neighbour, vis, adj);
            }
        }
    }
}
