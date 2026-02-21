import java.util.Stack;

class myQueue {

    private Stack<Integer> stack1; // for enqueue
    private Stack<Integer> stack2; // for dequeue/front

    // Constructor to initialize stacks
    public myQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue x at the rear
    void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue element from the front
    void dequeue() {
        if (stack2.isEmpty()) {
            // Move all elements from stack1 to stack2 to reverse order
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    // Return the front element
    int front() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.peek();
    }

    // Return current size of the queue
    int size() {
        return stack1.size() + stack2.size();
    }
}