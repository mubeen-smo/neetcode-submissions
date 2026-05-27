class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int[] output = new int[size];
        int i = 0;
        int product = 1;
        for(int n : nums) {
            output[i++] = product;
            product *= n;
        }

        product = 1;
        for(i = size-1; i >= 0; i--) {
            output[i] = product*output[i];
            product *= nums[i];
        }
        return output;
    }
}  
