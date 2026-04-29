class Solution {
    public static int findEquilibrium(int arr[]) {
        int totalSum = 0;
        
        // Step 1: Calculate total sum
        for (int num : arr) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        // Step 2: Traverse and check equilibrium
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            
            if (leftSum == rightSum) {
                return i; // equilibrium index
            }
            
            leftSum += arr[i];
        }
        
        return -1;
    }
}