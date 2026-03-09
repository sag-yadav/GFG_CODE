/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public Node LCA(Node root, Node n1, Node n2) {
        
        while (root != null) {
            
            // both nodes are in left subtree
            if (n1.data < root.data && n2.data < root.data) {
                root = root.left;
            }
            
            // both nodes are in right subtree
            else if (n1.data > root.data && n2.data > root.data) {
                root = root.right;
            }
            
            // nodes split here or one equals root
            else {
                return root;
            }
        }
        
        return null;
    }
}