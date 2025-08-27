// You are given an undirected graph consisting of V vertices and E edges represented by a list edges[][], along with an integer m. Your task is to determine whether it is possible to color the graph using at most m different colors such that no two adjacent vertices share the same color. Return true if the graph can be colored with at most m colors, otherwise return false.

// Note: The graph is indexed with 0-based indexing.

// Examples:

// Input: V = 4, edges[][] = [[0, 1], [1, 3], [2, 3], [3, 0], [0, 2]], m = 3
// Output: true
// Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices can be colored as follows:



class Solution {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        
         List<List<Integer>> adj = new ArrayList<>();
          for (int i = 0; i < v; i++) {
              adj.add(new ArrayList<>());
          }
    
          for (int[] edge : edges) {
              adj.get(edge[0]).add(edge[1]);
              adj.get(edge[1]).add(edge[0]);
          }
          
          int[] color = new int[v]; // Initialized with 0 (uncolored)
          return solve(0, color, adj, m);
    }
    
    private static boolean solve(int node, int[] color, List<List<Integer>> adj, int m) {
      if (node == color.length) return true; // All vertices colored successfully

      // Try coloring with different colors
      for (int col = 1; col <= m; col++) {
          if (isSafe(node, col, color, adj)) {
              color[node] = col; // Assign color

              if (solve(node + 1, color, adj, m)) return true; // Recurse

              color[node] = 0; // Backtrack
          }
      }

      return false; // No valid color found
   }

  private static boolean isSafe(int node, int col, int[] color, List<List<Integer>> adj) {
      for (int neighbor : adj.get(node)) {
          if (color[neighbor] == col) return false; // Adjacent node has the same color
      }
      return true;
  }
}