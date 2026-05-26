class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int[] output = new int[size];

        int product = 1;
        int i = 0;
        for(int n : nums) {
            output[i++] = product;
            product *= n;
        }
        product = 1;
        for (int j = size-1; j >= 0 ; j--) {
            output[j] = product*output[j];
            product *= nums[j];
        }

        return output;
    }
}  
