class Solution {
    public int findMin(int[] nums) {
        int size = nums.length;
        if(nums[0] <= nums[size-1]) return nums[0];
        else {
            int i = 1;
            while(nums[i] > nums[i-1]) {
                i++;
            }
            return nums[i];
        }
    }
}
