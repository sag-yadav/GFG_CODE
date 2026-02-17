// Node class
/* class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
} */

// Stack class
class myStack {

    private Node top;   // Points to top of stack
    private int size;   // Maintains current size

    public myStack() {
        top = null;
        size = 0;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Push element onto stack
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop element from stack
    public void pop() {
        if (top == null) {
            return;   // Stack is empty, do nothing
        }
        top = top.next;
        size--;
    }

    // Return top element
    public int peek() {
        if (top == null) {
            return -1;
        }
        return top.data;
    }

    // Return current size of stack
    public int size() {
        return size;
    }
}
