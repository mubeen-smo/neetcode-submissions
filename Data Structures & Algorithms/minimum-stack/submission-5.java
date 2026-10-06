class MinStack {

    long min;
    Deque<Long> stack;

    public MinStack() {
        stack = new ArrayDeque<>();    
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            min = val;
            stack.push(0L);
        } else {
            stack.push(val - min);
            if(val < min) min = val;
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;

        long top = stack.pop();

        if(top < 0) min -= top;
    }
    
    public int top() {
        long top = stack.peek();

        if(top < 0) return (int) min;
        return (int) (top + min);

    }
    
    public int getMin() {
        return (int) min;
    }
}
