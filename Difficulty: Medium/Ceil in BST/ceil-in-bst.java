/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        int ceil = -1;
        
        while (root != null) {
            
            // If exact value found
            if (root.data == x) {
                return root.data;
            }
            
            // Current node can be a possible ceil
            if (root.data > x) {
                ceil = root.data;
                root = root.left;
            } 
            else {
                root = root.right;
            }
        }
        
        return ceil;
    }
}