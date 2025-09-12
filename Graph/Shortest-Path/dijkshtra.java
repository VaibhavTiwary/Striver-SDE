// // Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, 
// represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
// // You have to find the shortest distance of all the vertices from the source vertex src, and return 
// an array of integers where the ith element denotes the shortest distance between ith node and source vertex 
// src.

// // Note: The Graph is connected and doesn't contain any negative weight edge.


// Using Min-Heap / Priority Queue (most common):

// Each vertex can be inserted/extracted → O(V log V)

// Each edge can cause a decrease-key operation → O(E log V)

// ✅ Total:


// O((V+E)logV)

import java.util.*;

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // Step 1: Build adjacency list (u, v, w)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w}); // undirected graph
        }

        // Step 2: Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: Min-Heap for (node, distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        // Step 4: Process nodes
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            // if (d > dist[node]) continue; // skip outdated entries

            for (int[] neigh : adj.get(node)) {
                int next = neigh[0], weight = neigh[1];
                if (d + weight < dist[next]) {
                    dist[next] = d + weight;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        return dist;
    }
}


