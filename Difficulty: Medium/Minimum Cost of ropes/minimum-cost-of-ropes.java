import java.util.PriorityQueue;

class Solution {
    public static int minCost(int[] arr) {

        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Insert all ropes into heap
        for (int rope : arr) {
            pq.add(rope);
        }

        int cost = 0;

        // Connect ropes until one rope remains
        while (pq.size() > 1) {

            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;

            cost += sum;

            // Add combined rope back
            pq.add(sum);
        }

        return cost;
    }
}