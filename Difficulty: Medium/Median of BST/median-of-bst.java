/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    int countNodes(Node root) {
        if (root == null) return 0;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    
    public int findMedian(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        
        inorder(root, list);
        
        int n = list.size();
        
        // As per problem statement
        if (n % 2 == 0) {
            return list.get((n / 2) - 1);
        } else {
            return list.get(n / 2);
        }
    }
}