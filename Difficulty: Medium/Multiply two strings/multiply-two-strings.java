class Solution {
    public String multiplyStrings(String s1, String s2) {
        
        // Handle sign
        boolean negative = false;
        
        if (s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
        }
        
        if (s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
        }
        
        // Remove leading zeros
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);
        
        // If any number becomes zero
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }
        
        int n = s1.length();
        int m = s2.length();
        
        int[] result = new int[n + m];
        
        // Multiply from right to left (manual multiplication)
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                
                int digit1 = s1.charAt(i) - '0';
                int digit2 = s2.charAt(j) - '0';
                
                int sum = result[i + j + 1] + digit1 * digit2;
                
                result[i + j + 1] = sum % 10;      // Store unit digit
                result[i + j] += sum / 10;         // Carry
            }
        }
        
        // Build final result string
        StringBuilder sb = new StringBuilder();
        
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        
        // Add negative sign if needed
        if (negative) {
            sb.insert(0, "-");
        }
        
        return sb.toString();
    }
    
    private String removeLeadingZeros(String str) {
        int i = 0;
        while (i < str.length() - 1 && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }
}