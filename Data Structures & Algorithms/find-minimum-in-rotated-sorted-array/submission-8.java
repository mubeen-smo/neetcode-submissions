class Solution {
    public int findMin(int[] nums) {
        
        int p = Integer.MIN_VALUE;

        for(int n : nums) {
            if(n < p) return n;
            p = n;
        }
        return nums[0];
    }
}
