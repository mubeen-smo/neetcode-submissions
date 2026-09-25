class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;

        int l = 0, r = 0;
        int[] result = new int[size - k + 1];
        Deque<Integer> q = new LinkedList();

        while(r < size) {
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }

            q.addLast(r);
            
            if(l > q.getFirst()) {
                 q.removeFirst();
            }

            if(r+1 >= k) {
                result[l++] = nums[q.getFirst()];
            }
            r++;
        }

        return result;
    }
}
