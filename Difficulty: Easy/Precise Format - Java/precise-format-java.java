import java.util.ArrayList;

class Solution {
    // Function to return an ArrayList with exact result and formatted result
    static ArrayList<Float> divisionWithPrecision(float a, float b) {
        ArrayList<Float> res = new ArrayList<>();
        
        float exact = a / b;
        float formatted = Math.round(exact * 1000f) / 1000f;
        
        res.add(exact);
        res.add(formatted);
        
        return res;
    }
}