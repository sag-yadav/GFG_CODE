// User function Template for Java

class Solution {
    static double switchCase(int choice, List<Double> arr) {
        
        if (choice == 1) {
            // Area of Circle
            double R = arr.get(0);
            return Math.PI * R * R;
        } 
        else if (choice == 2) {
            // Area of Rectangle
            double L = arr.get(0);
            double B = arr.get(1);
            return L * B;
        }
        
        return 0; // Default case (not required as per constraints)
    }
}