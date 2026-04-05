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
    
    int leafLevel = -1;
    
    boolean check(Node root) {
        return helper(root, 0);
    }
    
    boolean helper(Node node, int level) {
        if (node == null) return true;
        
        // If leaf node
        if (node.left == null && node.right == null) {
            if (leafLevel == -1) {
                leafLevel = level; // first leaf
                return true;
            }
            return level == leafLevel;
        }
        
        // Check left and right subtree
        return helper(node.left, level + 1) && 
               helper(node.right, level + 1);
    }
}