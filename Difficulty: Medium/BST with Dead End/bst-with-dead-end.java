/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        return checkDeadEnd(root, 1, Integer.MAX_VALUE);
    }

    private boolean checkDeadEnd(Node root, int min, int max) {
        if (root == null) {
            return false;
        }

        // If min and max become same, no further insertion possible
        if (min == max) {
            return true;
        }

        // Check left and right subtree
        return checkDeadEnd(root.left, min, root.data - 1) ||
               checkDeadEnd(root.right, root.data + 1, max);
    }
}