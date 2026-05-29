/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int getCount(Node root, int l, int h) {
        
        // Base case
        if (root == null) {
            return 0;
        }

        // If node value is smaller than range
        if (root.data < l) {
            return getCount(root.right, l, h);
        }

        // If node value is greater than range
        if (root.data > h) {
            return getCount(root.left, l, h);
        }

        // Node lies within range
        return 1 
            + getCount(root.left, l, h) 
            + getCount(root.right, l, h);
    }
}