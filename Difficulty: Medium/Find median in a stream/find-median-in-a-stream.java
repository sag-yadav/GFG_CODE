
class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> ans = new ArrayList<>();

        // Max Heap for smaller half
        PriorityQueue<Integer> left =
                new PriorityQueue<>(Collections.reverseOrder());

        // Min Heap for larger half
        PriorityQueue<Integer> right =
                new PriorityQueue<>();

        for (int num : arr) {

            // Step 1: Insert element
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            // Step 2: Balance heaps
            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            } else if (right.size() > left.size()) {
                left.offer(right.poll());
            }

            // Step 3: Find median
            if (left.size() == right.size()) {
                ans.add((left.peek() + right.peek()) / 2.0);
            } else {
                ans.add((double) left.peek());
            }
        }

        return ans;
    }
}