class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        int V = adj.size();
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        Queue<Integer> q = new LinkedList<>();
        
        // Start BFS from node 0
        visited[0] = true;
        q.offer(0);
        
        while (!q.isEmpty()) {
            
            int node = q.poll();
            ans.add(node);
            
            // Visit all neighbors
            for (int neighbor : adj.get(node)) {
                
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
        
        return ans;
    }
}