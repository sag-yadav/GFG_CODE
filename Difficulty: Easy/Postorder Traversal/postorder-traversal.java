/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        post(root, result);
        return result;
    }
    
    private void post(Node root, ArrayList<Integer> result) {
        if (root == null) return;
        
        // Step 1: Left
        post(root.left, result);
        
        // Step 2: Right
        post(root.right, result);
        
        // Step 3: Root
        result.add(root.data);
    }
}