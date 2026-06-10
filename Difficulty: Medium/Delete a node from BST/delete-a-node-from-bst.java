/* Structure of a Tree Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public Node delNode(Node root, int x) {
        if (root == null) return null;

        // Search for the node
        if (x < root.data) {
            root.left = delNode(root.left, x);
        } 
        else if (x > root.data) {
            root.right = delNode(root.right, x);
        } 
        else {
            // Node found

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            // Find inorder successor (smallest in right subtree)
            Node successor = findMin(root.right);

            // Replace current node data
            root.data = successor.data;

            // Delete successor node
            root.right = delNode(root.right, successor.data);
        }

        return root;
    }

    // Helper function to find minimum node
    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}