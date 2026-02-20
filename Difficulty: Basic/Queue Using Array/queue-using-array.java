class myQueue {

   int arr[];
   int capacity;
   int size=0;
   int front=0;
   int rear=-1;

    // Constructor
    public myQueue(int n) {
        // Define Data Structures
           capacity=n;
        arr= new int[n];
        
    }

    public boolean isEmpty() {
        // Check if queue is empty
            return size==0;
    }

    public boolean isFull() {
        // Check if queue is full
          return size==capacity;
    }

    public void enqueue(int x) {
        // Enqueue
          if(isFull())
          {
              return;
          }
            rear = (rear+1)%capacity;
              arr[rear]=x;
                size++;
    }

    public void dequeue() {
        // Dequeue
        if(isEmpty())
        {
            return;
        }
            front = (front+1)%capacity;
               size--;
    }

    public int getFront() {
        // Get front element
           if(isEmpty())
           {
               return -1;
           }
        return arr[front];
    }

    public int getRear() {
        // Get last element
            if(isEmpty())
            {
                return -1;
            }
        return arr[rear];
    }
}
