
class Solution {

    public boolean isCycle(int V, int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Check all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        Queue<int[]> q = new LinkedList<>();

        visited[start] = true;
        q.offer(new int[]{start, -1});

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int node = curr[0];
            int parent = curr[1];

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, node});

                } else if (neighbor != parent) {

                    // Visited neighbor not equal to parent => cycle
                    return true;
                }
            }
        }

        return false;
    }
}