/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {

    // Merge two sorted bottom linked lists
    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        // next pointer is no longer needed
        result.next = null;

        return result;
    }

    public Node flatten(Node root) {

        // Base case
        if (root == null || root.next == null)
            return root;

        // Flatten the remaining list
        root.next = flatten(root.next);

        // Merge current list with flattened next list
        root = merge(root, root.next);

        return root;
    }
}