import java.util.*;

class Solution {
    public void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Push all elements into stack
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }
        
        // Step 2: Push elements back to queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }
}