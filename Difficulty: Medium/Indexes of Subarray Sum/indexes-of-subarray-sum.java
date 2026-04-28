
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            // Shrink window if sum exceeds target
            while (currentSum > target && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            // If sum equals target
            if (currentSum == target) {
                result.add(start + 1); // 1-based index
                result.add(end + 1);
                return result;
            }
        }

        // If no subarray found
        result.add(-1);
        return result;
    }
}