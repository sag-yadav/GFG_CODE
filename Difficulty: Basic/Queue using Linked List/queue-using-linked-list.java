// Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Queue class
class myQueue {

    private Node front, rear;
    private int size;

    public myQueue() {
        front = rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int x) {
        Node newNode = new Node(x);

        if (rear == null) {     // Queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public void dequeue() {
        if (front == null) {
            return; // Queue is empty
        }

        front = front.next;

        if (front == null) {   // Queue became empty
            rear = null;
        }

        size--;
    }

    public int getFront() {
        if (front == null) {
            return -1;
        }
        return front.data;
    }

    public int size() {
        return size;
    }
}