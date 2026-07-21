import java.util.*;

class Solution {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {

        // Create Adjacency List
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (Undirected Graph)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        // Distance Array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.weight;

            if (d > dist[node])
                continue;

            // Traverse neighbours
            for (Pair neighbour : adj.get(node)) {

                int nextNode = neighbour.node;
                int wt = neighbour.weight;

                if (dist[node] + wt < dist[nextNode]) {

                    dist[nextNode] = dist[node] + wt;
                    pq.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return dist;
    }
}