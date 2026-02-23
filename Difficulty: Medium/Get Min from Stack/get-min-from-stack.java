import java.util.Stack;

class SpecialStack {

    private Stack<Integer> stack;     // Main stack
    private Stack<Integer> minStack;  // Minimum tracking stack

    public SpecialStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Add element to top
    public void push(int x) {
        stack.push(x);

        // Agar minStack empty hai ya x current min se chota/equal hai
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Remove top element
    public void pop() {
        if (stack.isEmpty())
            return;

        int removed = stack.pop();

        // Agar removed element minimum tha to minStack se bhi hatao
        if (!minStack.isEmpty() && removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Return top element
    public int peek() {
        if (stack.isEmpty())
            return -1;

        return stack.peek();
    }

    // Check if empty
    boolean isEmpty() {
        return stack.isEmpty();
    }

    // Return minimum element
    public int getMin() {
        if (minStack.isEmpty())
            return -1;

        return minStack.peek();
    }
}