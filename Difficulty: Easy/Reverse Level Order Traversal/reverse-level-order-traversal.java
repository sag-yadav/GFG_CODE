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

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (root == null) return result;
        
        Queue<Node> q = new LinkedList<>();
        Stack<Node> st = new Stack<>();
        
        q.add(root);
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            st.push(curr);
            
            // Important: right first, then left
            if (curr.right != null) q.add(curr.right);
            if (curr.left != null) q.add(curr.left);
        }
        
        // Pop from stack to get reverse order
        while (!st.isEmpty()) {
            result.add(st.pop().data);
        }
        
        return result;
    }
}