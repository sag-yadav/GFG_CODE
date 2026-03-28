/*
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    void mirror(Node root) {
        if (root == null) return;
        
        // Swap left and right child
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // Recur for left and right subtree
        mirror(root.left);
        mirror(root.right);
    }
}