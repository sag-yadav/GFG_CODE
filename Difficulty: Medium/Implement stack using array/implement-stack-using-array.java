class myStack {
    
    int[] arr;
    int top;
    int size;

    public myStack(int n) {
        arr = new int[n];
        size = n;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int x) {
        if (!isFull()) {
            arr[++top] = x;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            top--;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        return -1;
    }
}