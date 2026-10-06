class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for(int i = 1; i < size; i++) {
            int currTemp = temperatures[i];
            if(stack.isEmpty()) continue;
            while(temperatures[stack.peek()] < currTemp) {
                result[stack.peek()] = i - stack.pop();
                if(stack.isEmpty()) break;
            }
            stack.push(i);
        }

        return result;

        
    }
}
