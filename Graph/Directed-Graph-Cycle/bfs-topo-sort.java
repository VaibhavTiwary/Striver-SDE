// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
// The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.



class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        
        int[] indegree = new int[V];
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); 
        }
        
        for(int i = 0; i < V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue <Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        ArrayList <Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            topo.add(node);
            
            for(int it : adj.get(node)){
                indegree[it]--;
                
                if(indegree[it] == 0){
                    queue.add(it);
                }
                
            }
        }
        
        if(topo.size() == V) return false;
        return true;
    }
}