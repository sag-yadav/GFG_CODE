
class Solution {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        
        int ans = arr[n - 1] - arr[0]; // initial difference
        
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        
        for (int i = 0; i < n - 1; i++) {
            int min = Math.min(smallest, arr[i + 1] - k);
            int max = Math.max(largest, arr[i] + k);
            
            // Skip invalid case (negative height)
            if (min < 0) continue;
            
            ans = Math.min(ans, max - min);
        }
        
        return ans;
    }
}