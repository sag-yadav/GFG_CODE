import java.util.*;

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> st = new Stack<>(); // stores indices
        
        for (int i = 0; i < n; i++) {
            // Pop elements smaller than or equal to current
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            
            // Calculate span
            if (st.isEmpty()) {
                span.add(i + 1);
            } else {
                span.add(i - st.peek());
            }
            
            // Push current index
            st.push(i);
        }
        
        return span;
    }
}