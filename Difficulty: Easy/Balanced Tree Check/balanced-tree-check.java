/*
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    int checkHeight(Node root) {
        if (root == null) return 0;
        
        int left = checkHeight(root.left);
        if (left == -1) return -1;
        
        int right = checkHeight(root.right);
        if (right == -1) return -1;
        
        if (Math.abs(left - right) > 1) return -1;
        
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }
}