class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        Deque<Integer> q = new LinkedList<>();

        int l = 0, r = 0;
        int[] output = new int[size - k + 1];

        while(r < size) {
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if(l > q.getFirst()) {
                q.removeFirst();
            }

            if(l > q.getFirst()) {
                q.removeFirst();
            }

            if((r+1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
        
    }
}
