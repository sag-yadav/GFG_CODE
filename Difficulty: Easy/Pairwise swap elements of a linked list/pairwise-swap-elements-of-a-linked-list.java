/* node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    // Function to pairwise swap elements of a linked list.
    public Node pairwiseSwap(Node head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node curr = head;

        // New head will be second node
        head = head.next;

        while (curr != null && curr.next != null) {
            Node next = curr.next;
            Node nextPair = next.next;

            // Swap current pair
            next.next = curr;
            curr.next = nextPair;

            // Connect previous pair with current swapped pair
            if (prev != null) {
                prev.next = next;
            }

            // Move prev and curr forward
            prev = curr;
            curr = nextPair;
        }

        return head;
    }
}