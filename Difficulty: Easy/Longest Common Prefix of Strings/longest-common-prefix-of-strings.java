// User function Template for Java
class Solution {
    public String longestCommonPrefix(String arr[]) {
        // Edge case
        if (arr == null || arr.length == 0)
            return "";
        
        // Take first string as initial prefix
        String prefix = arr[0];
        
        // Compare prefix with every other string
        for (int i = 1; i < arr.length; i++) {
            
            // Reduce prefix until it matches start of current string
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix becomes empty
                if (prefix.isEmpty())
                    return "";
            }
        }
        
        return prefix;
    }
}