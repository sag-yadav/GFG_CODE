
class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        
        dfsTraversal(0, adj, visited, ans);
        
        return ans;
    }
    
    void dfsTraversal(int node, ArrayList<ArrayList<Integer>> adj,
                      boolean[] visited, ArrayList<Integer> ans) {
        
        visited[node] = true;
        ans.add(node);
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsTraversal(neighbor, adj, visited, ans);
            }
        }
    }
}
