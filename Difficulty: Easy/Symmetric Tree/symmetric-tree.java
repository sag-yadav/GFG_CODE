/*
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
    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(Node left, Node right) {
        // दोनों null हैं → symmetric
        if (left == null && right == null) return true;

        // एक null है → not symmetric
        if (left == null || right == null) return false;

        // values match + mirror check
        return (left.data == right.data) &&
               isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}