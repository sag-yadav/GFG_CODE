class Solution {

    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s) {
        int size = s.size();
        int mid = size / 2;   // index from top (0-based)
        deleteHelper(s, mid);
    }

    private void deleteHelper(Stack<Integer> s, int k) {
        // Base case: remove the middle element
        if (k == 0) {
            s.pop();
            return;
        }

        // Store top element
        int temp = s.pop();

        // Recursive call
        deleteHelper(s, k - 1);

        // Push element back after recursion
        s.push(temp);
    }
}