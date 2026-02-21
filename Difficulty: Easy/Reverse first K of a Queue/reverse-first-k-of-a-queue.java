import java.util.*;

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        
        // Edge cases
        if (q == null || k <= 0 || q.size() < k) {
            return q;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Remove first k elements and push into stack
        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }
        
        // Step 2: Add stack elements back to queue (reversed order)
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        
        // Step 3: Move remaining elements to the back
        int remaining = q.size() - k;
        for (int i = 0; i < remaining; i++) {
            q.add(q.remove());
        }
        
        return q;
    }
}