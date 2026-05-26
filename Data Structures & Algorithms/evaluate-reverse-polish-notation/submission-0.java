class Solution {
    public int evalRPN(String[] tokens) {
        int size = tokens.length;
Deque<Integer> stack = new ArrayDeque<>();
        for(String s : tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                
                    int a = stack.pop();
                    int b = stack.pop();
                if(s.equals("+")) stack.push(b + a);
                else if( s.equals("-")) stack.push(b - a);
                else if(s.equals("*")) stack.push(b * a);
                else {
                    if(a != 0) stack.push(b/a);
                }
            }
                else stack.push(Integer.parseInt(s));

        }
        return stack.pop();
    }
}
