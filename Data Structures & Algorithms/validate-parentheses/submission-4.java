class Solution {
    public boolean isValid(String s) {
        int size = s.length();

        if(size < 2) return false;
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else {
                if(stack.isEmpty() || (!stack.isEmpty() && !(c == stack.pop()))) return false;
            }
        }
        return stack.isEmpty();
    }
}
