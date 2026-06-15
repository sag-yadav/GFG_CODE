class twoStacks {
    
    int size = 100;
    int arr[] = new int[size];
    
    int top1, top2;

    twoStacks() {
        top1 = -1;
        top2 = size;
    }

    // Function to push an integer into stack1.
    void push1(int x) {
        // Check if space is available
        if (top1 < top2 - 1) {
            arr[++top1] = x;
        }
    }

    // Function to push an integer into stack2.
    void push2(int x) {
        // Check if space is available
        if (top1 < top2 - 1) {
            arr[--top2] = x;
        }
    }

    // Function to remove an element from top of stack1.
    int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        }
        return -1;
    }

    // Function to remove an element from top of stack2.
    int pop2() {
        if (top2 < size) {
            return arr[top2++];
        }
        return -1;
    }
}