class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        solve(0, 0, arr, result);
        return result;
    }
    
    private void solve(int index, int sum, int[] arr, ArrayList<Integer> result) {
        // Base case
        if (index == arr.length) {
            result.add(sum);
            return;
        }
        
        // Include current element
        solve(index + 1, sum + arr[index], arr, result);
        
        // Exclude current element
        solve(index + 1, sum, arr, result);
    }
}