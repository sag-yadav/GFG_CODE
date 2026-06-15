import java.util.*;

class Solution {
    
    // Function to return precedence of operators
    static int precedence(char ch) {
        if (ch == '^')
            return 3;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '+' || ch == '-')
            return 1;
        else
            return -1;
    }

    public static String infixToPostfix(String s) {
        
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If operand, add to answer
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }

            // If '(', push to stack
            else if (ch == '(') {
                st.push(ch);
            }

            // If ')', pop until '('
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                st.pop(); // remove '('
            }

            // Operator case
            else {
                while (!st.isEmpty() &&
                       ((precedence(ch) < precedence(st.peek())) ||
                       (precedence(ch) == precedence(st.peek()) && ch != '^'))) {
                    
                    result.append(st.pop());
                }
                st.push(ch);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.toString();
    }
}