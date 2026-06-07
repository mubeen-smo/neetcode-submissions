class Solution {
    public int evalRPN(String[] tokens) {
       // Set<String> operations = new HashSet<>({"+","-","*","/"});
        String operations = "+ - * /";
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s : tokens) {
            if(operations.contains(s)) {
                int b = stack.pop();
                int a = stack.pop();
                 int res = calculate(a, b, s);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    public int calculate(int a, int b, String o) {
        if(o.equals("+")) return a + b;
        else if(o.equals("*")) return a * b;
        else if(o.equals("-")) return a - b;
        else {
            if(b != 0) return a/b;
            else return 0;
        }
    }
}
