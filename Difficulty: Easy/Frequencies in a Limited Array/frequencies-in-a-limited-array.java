class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        int n = arr.length;
        
        int[] freq = new int[n];
        
        // Count frequency
        for (int num : arr) {
            freq[num - 1]++;
        }
        
        // Store result in List
        List<Integer> result = new ArrayList<>();
        
        for (int count : freq) {
            result.add(count);
        }
        
        return result;
    }
}