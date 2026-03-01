class Solution {
    public static boolean isRotated(String s1, String s2) {
        // Length must be equal
        if (s1.length() != s2.length())
            return false;
        
        int n = s1.length();
        
        // If length is less than 2
        if (n < 2)
            return s1.equals(s2);
        
        // Left rotation by 2 (anti-clockwise)
        String leftRotate = s1.substring(2) + s1.substring(0, 2);
        
        // Right rotation by 2 (clockwise)
        String rightRotate = s1.substring(n - 2) + s1.substring(0, n - 2);
        
        return s2.equals(leftRotate) || s2.equals(rightRotate);
    }
}