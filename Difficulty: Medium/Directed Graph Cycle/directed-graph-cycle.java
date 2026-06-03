
class Solution {

    public boolean isCyclic(int V, int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add directed edges
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        // Check all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node,
                        ArrayList<ArrayList<Integer>> adj,
                        boolean[] visited,
                        boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {

            // If not visited, do DFS
            if (!visited[neighbor]) {

                if (dfs(neighbor, adj, visited, pathVisited)) {
                    return true;
                }

            }
            // If already in current path -> cycle
            else if (pathVisited[neighbor]) {
                return true;
            }
        }

        // Backtrack
        pathVisited[node] = false;

        return false;
    }
}