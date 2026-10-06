class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int size = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for(int i = 0; i <= size; i++) {
            
            while(!stack.isEmpty() && (i == size || heights[stack.peek()] > heights[i])) {
                
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(h*w, maxArea);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
