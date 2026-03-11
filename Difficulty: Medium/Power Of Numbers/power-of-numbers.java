class Solution {
    public int reverseExponentiation(int n) {
        
        int rev = 0;
        int temp = n;
        
        // Step 1: Reverse the number
        while(temp > 0){
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp = temp / 10;
        }
        
        // Step 2: Compute n^rev
        int result = 1;
        for(int i = 0; i < rev; i++){
            result = result * n;
        }
        
        return result;
    }
}