import java.util.*;

class Solution {
    public int evaluatePostfix(String[] arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            
            String token = arr[i];
            
            // If operator
            if (token.equals("+") || token.equals("-") || 
                token.equals("*") || token.equals("/") || 
                token.equals("^")) {
                
                int b = stack.pop();  // second operand
                int a = stack.pop();  // first operand
                
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(Math.floorDiv(a, b)); // floor division
                        break;
                    case "^":
                        stack.push((int)Math.pow(a, b));
                        break;
                }
            } 
            // If number
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
