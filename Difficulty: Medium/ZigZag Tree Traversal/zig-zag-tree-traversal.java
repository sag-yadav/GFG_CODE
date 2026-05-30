/*
Definition for Node
class Node {
    int data;
    Node left, right;
    Node(int d)
    {
        data  =d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (root == null) return ans;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        boolean leftToRight = true;
        
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                level.add(curr.data);
                
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            
            if (!leftToRight) {
                Collections.reverse(level);
            }
            
            ans.addAll(level);
            leftToRight = !leftToRight;
        }
        
        return ans;
    }
}