class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int neighbour : adj.get(node)) {
                if (!vis[neighbour]) {
                    q.add(neighbour);
                    vis[neighbour] = true;  // Mark as visited when adding to queue
                }
            }
        }
        return ans;
    }
}
