/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    boolean findTarget(Node root, int target) {
        HashSet<Integer> set = new HashSet<>();
        return solve(root, target, set);
    }
    
    boolean solve(Node root, int target, HashSet<Integer> set) {
        if (root == null) return false;
        
        // Check left subtree
        if (solve(root.left, target, set)) return true;
        
        // Check current node
        if (set.contains(target - root.data)) {
            return true;
        }
        set.add(root.data);
        
        // Check right subtree
        return solve(root.right, target, set);
    }
}