/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        
        if (head == null) return 0;
        
        Node slow = head;
        Node fast = head;
        
        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                // Loop found → count its length
                int count = 1;
                Node temp = slow;
                
                while (temp.next != slow) {
                    count++;
                    temp = temp.next;
                }
                
                return count;
            }
        }
        
        // No loop
        return 0;
    }
}