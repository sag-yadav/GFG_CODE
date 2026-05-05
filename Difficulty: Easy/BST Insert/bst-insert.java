/*
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
    public Node insert(Node root, int key) {
        // Base case: if root is null, create new node
        if (root == null) {
            return new Node(key);
        }

        // If key is smaller, go to left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        // If key is greater, go to right subtree
        else {
            root.right = insert(root.right, key);
        }

        // Return the root node
        return root;
    }
}
