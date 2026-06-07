import java.util.*;

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        int[] res = new int[n];
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            
            // Remove elements greater than or equal to current
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            
            // If stack empty, no smaller element exists
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            
            // Push current element
            st.push(arr[i]);
        }
        
        // Convert array to ArrayList
        for (int x : res) {
            ans.add(x);
        }
        
        return ans;
    }
}