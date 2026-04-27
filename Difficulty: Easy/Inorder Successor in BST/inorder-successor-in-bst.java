/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public int inorderSuccessor(Node root, Node x) {
        Node successor = null;

        while (root != null) {
            if (x.data < root.data) {
                successor = root;     // possible successor
                root = root.left;
            } else {
                root = root.right;
            }
        }

        // if no successor found
        return (successor != null) ? successor.data : -1;
    }
}