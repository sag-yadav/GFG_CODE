
class StackQueue {
    
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Function to push an element in queue by using 2 stacks.
    public void push(int B) {
        s1.push(B);
    }

    // Function to pop an element from queue by using 2 stacks.
    public int pop() {
        
        if (s1.isEmpty() && s2.isEmpty()) {
            return -1;
        }
        
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        
        return s2.pop();
    }
}
