class Solution {
    public int evalRPN(String[] tokens) {
        // The stack will never exceed the number of tokens
        int[] stack = new int[tokens.length];
        int top = 0;

        for (String s : tokens) {
            // Check if the token is an operator
            // Length check protects against negative numbers like "-5"
            if (s.length() == 1 && "+-*/".indexOf(s.charAt(0)) != -1) {
                int b = stack[--top];
                int a = stack[--top];
                
                // Use a fast switch expression instead of helper method calls
                switch (s.charAt(0)) {
                    case '+': stack[top++] = a + b; break;
                    case '-': stack[top++] = a - b; break;
                    case '*': stack[top++] = a * b; break;
                    case '/': stack[top++] = a / b; break;
                }
            } else {
                // Inline parsing directly into the primitive array
                stack[top++] = Integer.parseInt(s);
            }
        }
        return stack[0];
    }
}
