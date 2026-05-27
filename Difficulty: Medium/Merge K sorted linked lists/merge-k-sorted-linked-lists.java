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
    Node mergeKLists(Node[] arr) {

        // Min Heap based on node data
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.data - b.data
        );

        // Add head nodes of all lists
        for (Node head : arr) {
            if (head != null) {
                pq.offer(head);
            }
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        // Process smallest node each time
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            tail.next = curr;
            tail = tail.next;

            // Add next node of current list
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return dummy.next;
    }
}