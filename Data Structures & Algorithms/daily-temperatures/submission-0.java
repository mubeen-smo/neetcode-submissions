class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < size; i++) {
            if(stack.isEmpty()) {
                stack.push(0);
            }
            else {
                int t = temperatures[i];
                while(!stack.isEmpty() && temperatures[stack.peek()] < t) {
                    int pop = stack.pop();
                    result[pop] = i - pop;
                }
                stack.push(i);
            }
        }

        return result;
    }
}
