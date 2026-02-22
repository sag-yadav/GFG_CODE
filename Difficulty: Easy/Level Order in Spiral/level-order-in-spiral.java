/*
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
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (root == null) return result;
        
        Stack<Node> s1 = new Stack<>(); // Even levels (Right -> Left)
        Stack<Node> s2 = new Stack<>(); // Odd levels (Left -> Right)
        
        s1.push(root);
        
        while (!s1.isEmpty() || !s2.isEmpty()) {
            
            // Level 0,2,4... (Right to Left)
            while (!s1.isEmpty()) {
                Node curr = s1.pop();
                result.add(curr.data);
                
                // Push right first, then left
                if (curr.right != null) s2.push(curr.right);
                if (curr.left != null) s2.push(curr.left);
            }
            
            // Level 1,3,5... (Left to Right)
            while (!s2.isEmpty()) {
                Node curr = s2.pop();
                result.add(curr.data);
                
                // Push left first, then right
                if (curr.left != null) s1.push(curr.left);
                if (curr.right != null) s1.push(curr.right);
            }
        }
        
        return result;
    }
}