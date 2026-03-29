/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }
    
    void inorder(Node root, ArrayList<Integer> ans) {
        if (root == null) return;
        
        inorder(root.left, ans);   // Left
        ans.add(root.data);        // Root
        inorder(root.right, ans);  // Right
    }
}