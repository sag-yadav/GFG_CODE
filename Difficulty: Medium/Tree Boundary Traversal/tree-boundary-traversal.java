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
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        
        if (root == null) return res;
        
        if (!isLeaf(root)) res.add(root.data);
        
        addLeftBoundary(root, res);
        addLeavesIterative(root, res);  // FIXED HERE
        addRightBoundary(root, res);
        
        return res;
    }
    
    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
    
    void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root.left;
        
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.data);
            
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    
    // ✅ ITERATIVE LEAF TRAVERSAL (NO STACK OVERFLOW)
    void addLeavesIterative(Node root, ArrayList<Integer> res) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            
            if (isLeaf(curr)) {
                res.add(curr.data);
            }
            
            // push right first so left is processed first
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }
    
    void addRightBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data);
            
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }
}