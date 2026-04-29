
class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        
        long sum = 0, squareSum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            squareSum += (long) arr[i] * arr[i];
        }
        
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2 * n + 1) / 6;
        
        long diff = expectedSum - sum;              // M - R
        long squareDiff = expectedSquareSum - squareSum; // M^2 - R^2
        
        long sumMR = squareDiff / diff;             // M + R
        
        int missing = (int) ((diff + sumMR) / 2);
        int repeating = (int) (sumMR - missing);
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        
        return result;
    }
}