/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    
    // Function to reverse the linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public Node addOne(Node head) {
        
        // Step 1: Reverse the linked list
        head = reverse(head);
        
        Node temp = head;
        int carry = 1;   // We need to add 1
        
        // Step 2: Add 1 and propagate carry
        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;
            
            if (carry == 0) break;
            temp = temp.next;
        }
        
        // Step 3: If carry is still left, add a new node
        if (carry > 0) {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(carry);
        }
        
        // Step 4: Reverse back to restore original order
        head = reverse(head);
        
        return head;
    }
}