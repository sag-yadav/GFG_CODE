/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    
    public Node addTwoLists(Node head1, Node head2) {
        
        // Step 1: Reverse both lists
        head1 = reverse(head1);
        head2 = reverse(head2);
        
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;
        
        // Step 2: Add digits
        while (head1 != null || head2 != null || carry != 0) {
            
            int sum = carry;
            
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
        }
        
        // Step 3: Reverse the result
        Node result = reverse(dummy.next);
        
        // Step 4: Remove leading zeros (if any)
        while (result != null && result.data == 0 && result.next != null) {
            result = result.next;
        }
        
        return result;
    }
    
    // Helper function to reverse a linked list
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
}