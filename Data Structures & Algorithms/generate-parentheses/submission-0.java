class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(new StringBuilder("("), n);
        return res;
    }

    private void backtrack(StringBuilder sb, int n) {
        String s = sb.toString();
        if(s.length() >= 2*n) {
            if(isValid(s)) res.add(new String(s));
            return;
        }
        sb.append("(");
        backtrack(sb, n);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        backtrack(sb, n);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty() || stack.pop() != '(') return false;
            }
        }
        return stack.isEmpty();
    }
}
