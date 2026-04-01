/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    int count = 0;
    int result = -1;

    public int kthLargest(Node root, int k) {
        reverseInorder(root, k);
        return result;
    }

    private void reverseInorder(Node root, int k) {
        if (root == null || count >= k) return;

        // Step 1: Go right
        reverseInorder(root.right, k);

        // Step 2: Visit node
        count++;
        if (count == k) {
            result = root.data;
            return;
        }

        // Step 3: Go left
        reverseInorder(root.left, k);
    }
}