class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            if(i > 0) {
                while(!stack.isEmpty() && (temperatures[stack.peek()] < temperatures[i])) {
                    int top = stack.peek();
                    result[stack.pop()] = i - top;
                }
            }
            stack.push(i);
        }
        return result;
    }
}
