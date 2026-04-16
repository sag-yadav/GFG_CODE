/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    public int findMaxFork(Node root, int k) {
        int ans = -1;
        
        while (root != null) {
            if (root.data == k) {
                return k; // exact match
            }
            
            if (root.data < k) {
                ans = root.data; // possible answer
                root = root.right; // try to find bigger
            } else {
                root = root.left; // go smaller
            }
        }
        
        return ans;
    }
}