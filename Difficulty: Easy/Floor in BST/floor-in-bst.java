/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int findMaxFork(Node root, int k) {
        int floor = -1;
        
        while (root != null) {
            
            // Exact match
            if (root.data == k) {
                return root.data;
            }
            
            // Current node is smaller, can be a possible answer
            if (root.data < k) {
                floor = root.data;
                root = root.right;
            } 
            // Current node is greater, move left
            else {
                root = root.left;
            }
        }
        
        return floor;
    }
}