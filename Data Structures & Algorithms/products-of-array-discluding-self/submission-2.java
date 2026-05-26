class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int product = 1;

        int[] output = new int[l];
        int i = 0;
        for(int n : nums) {
            output[i++] = product;
            product = product*n;
        }
        product = 1;
        for(i = l-1; i >= 0; i--) {
            output[i] = product*output[i];
            product = product*nums[i];
        }

        return output;
    }
}  
