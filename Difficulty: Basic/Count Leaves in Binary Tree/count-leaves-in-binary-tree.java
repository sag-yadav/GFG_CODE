/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
}*/

class Solution {
    int countLeaves(Node node) {
        // Base case
        if (node == null) return 0;

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            return 1;
        }

        // Count leaves in left and right subtree
        return countLeaves(node.left) + countLeaves(node.right);
    }
}