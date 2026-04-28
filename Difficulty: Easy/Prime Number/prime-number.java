class Solution {
    static boolean isPrime(int n) {
        // Numbers less than or equal to 1 are not prime
        if (n <= 1) return false;

        // 2 is the only even prime number
        if (n == 2) return true;

        // Eliminate other even numbers
        if (n % 2 == 0) return false;

        // Check for factors from 3 to √n
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}