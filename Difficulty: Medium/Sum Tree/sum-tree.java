/* A Binary Tree node
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
    
    boolean isSumTree(Node root) {
        return solve(root) != -1;
    }
    
    int solve(Node node) {
        if (node == null)
            return 0;
        
        // Leaf node
        if (node.left == null && node.right == null)
            return node.data;
        
        int leftSum = solve(node.left);
        int rightSum = solve(node.right);
        
        // If any subtree is not a Sum Tree
        if (leftSum == -1 || rightSum == -1)
            return -1;
        
        // Check Sum Tree condition
        if (node.data != leftSum + rightSum)
            return -1;
        
        // Return total sum of current subtree
        return node.data + leftSum + rightSum;
    }
}

