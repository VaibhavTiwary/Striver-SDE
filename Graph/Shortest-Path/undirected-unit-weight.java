// In unit weight graphs, all edges have cost = 1.

// BFS explores the graph level by level:

// From source, first explores all nodes at distance 1.

// Then all nodes at distance 2.

// And so on…

// That’s exactly what shortest path requires → the first time you reach a node in BFS, you already found its minimum distance.

// No need for a priority queue (like in Dijkstra).

// 👉 Complexity:

// BFS: O(V + E)

// Dijkstra: O((V + E) log V)

// So BFS is both faster and simpler here.


import java.util.*;

class Solution {
    public int[] shortestPath(int V, List<List<Integer>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        dist[src] = 0;
        queue.add(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbour : adj.get(node)) {
                if (dist[node] + 1 < dist[neighbour]) {
                    dist[neighbour] = dist[node] + 1;
                    queue.add(neighbour);
                }
            }
        }

        return dist;
    }
}
