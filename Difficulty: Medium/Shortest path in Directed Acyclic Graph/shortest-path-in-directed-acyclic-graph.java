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

    public int[] shortestPath(int V, int E, int[][] edges) {

        // Adjacency List
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build Graph
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
        }

        // Indegree Array
        int[] indegree = new int[V];

        for (int i = 0; i < E; i++) {
            indegree[edges[i][1]]++;
        }

        // Topological Sort (Kahn's Algorithm)
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();
            topo.add(node);

            for (Pair nbr : adj.get(node)) {

                indegree[nbr.node]--;

                if (indegree[nbr.node] == 0) {
                    q.offer(nbr.node);
                }
            }
        }

        // Distance Array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        // Relax Edges
        for (int node : topo) {

            if (dist[node] != Integer.MAX_VALUE) {

                for (Pair nbr : adj.get(node)) {

                    if (dist[node] + nbr.weight < dist[nbr.node]) {

                        dist[nbr.node] = dist[node] + nbr.weight;
                    }
                }
            }
        }

        // Replace Infinity with -1
        for (int i = 0; i < V; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}