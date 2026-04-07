/*
// A Binary Tree node
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    boolean hasPathSum(Node root, int target) {
        // Base case: empty tree
        if (root == null) return false;

        // If it's a leaf node
        if (root.left == null && root.right == null) {
            return target == root.data;
        }

        // Remaining sum after subtracting current node value
        int remaining = target - root.data;

        // Check in left or right subtree
        return hasPathSum(root.left, remaining) || 
               hasPathSum(root.right, remaining);
    }
}