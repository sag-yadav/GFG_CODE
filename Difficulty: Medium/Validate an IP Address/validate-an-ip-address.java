
  class Solution {
    public boolean isValid(String s) {
        // Split into parts (keep empty parts)
        String[] parts = s.split("\\.", -1);
        
        // Check for exactly 4 parts
        if (parts.length != 4) return false;
        
        for (String part : parts) {
            // Empty part check
            if (part.length() == 0) return false;
            
            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0') return false;
            
            // Check all characters are digits
            for (int i = 0; i < part.length(); i++) {
                if (!Character.isDigit(part.charAt(i))) return false;
            }
            
            // Convert to number and check range
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
        }
        
        return true;
    }
}