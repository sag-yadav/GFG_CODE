/*
Definition for Node
class Node {
    int data;
    Node left, right;

    public Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    int count = 0;
    int ans = -1;
    
    public int kthSmallest(Node root, int k) {
        
        inorder(root, k);
        return ans;
    }
    
    void inorder(Node root, int k) {
        
        if(root == null) return;
        
        // Traverse left subtree
        inorder(root.left, k);
        
        // Visit current node
        count++;
        
        if(count == k) {
            ans = root.data;
            return;
        }
        
        // Traverse right subtree
        inorder(root.right, k);
    }
}