/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        
        dfs(root, path, ans);
        
        return ans;
    }
    
    void dfs(Node root, ArrayList<Integer> path, 
             ArrayList<ArrayList<Integer>> ans) {
        
        if(root == null) return;
        
        // Add current node to path
        path.add(root.data);
        
        // If leaf node, store the path
        if(root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        } else {
            // Traverse left and right subtree
            dfs(root.left, path, ans);
            dfs(root.right, path, ans);
        }
        
        // Backtrack
        path.remove(path.size() - 1);
    }
}