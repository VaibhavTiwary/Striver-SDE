class Solution {
   
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); 
        }
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i, -1, vis, adj)) return true;
            }
            
        }
        return false;
        
    }
    
    boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = true;
        
        for(int neighbour : adj.get(node)){
            
            if(!vis[neighbour]){
                // vis[neighbour] = true;
                if(dfs(neighbour, node, vis, adj)) return true;
                
            } else {
                if(neighbour != parent) return true;
            }
        }
        return false;
        
    }
}