/*
class Node {
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    
    int countNodes(Node root) {
        if (root == null)
            return 0;
            
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    boolean isCBT(Node root, int index, int totalNodes) {
        // Check Complete Binary Tree
        if (root == null)
            return true;
            
        if (index >= totalNodes)
            return false;
            
        return isCBT(root.left, 2 * index + 1, totalNodes) &&
               isCBT(root.right, 2 * index + 2, totalNodes);
    }
    
    boolean isMaxHeap(Node root) {
        // Check Max Heap Property
        
        // Leaf node
        if (root.left == null && root.right == null)
            return true;
            
        // Only left child
        if (root.right == null) {
            return root.data >= root.left.data;
        }
        
        // Both children exist
        return (root.data >= root.left.data &&
                root.data >= root.right.data &&
                isMaxHeap(root.left) &&
                isMaxHeap(root.right));
    }
    
    public boolean isHeap(Node tree) {
        int totalNodes = countNodes(tree);
        
        return isCBT(tree, 0, totalNodes) && isMaxHeap(tree);
    }
}