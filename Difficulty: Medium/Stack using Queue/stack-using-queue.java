import java.util.Queue;
import java.util.LinkedList;

class myStack {
    Queue<Integer> q = new LinkedList<>();

    // Push element to top
    void push(int x) {
        int n = q.size();
        q.add(x);  // Add new element at end

        // Rotate the previous elements to the back
        for (int i = 0; i < n; i++) {
            q.add(q.remove());
        }
    }

    // Remove top element
    void pop() {
        if (!q.isEmpty()) {
            q.remove(); // Front of queue is top of stack
        }
    }

    // Return top element
    int top() {
        if (q.isEmpty()) return -1;
        return q.peek(); // Front of queue
    }

    // Return current size
    int size() {
        return q.size();
    }
}