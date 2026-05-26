class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        
        int[] res = new int[l];
        int i = 0;
        int product = 1;
        for(int n : nums) {
            res[i++] = product;
            product *= n;
        }
        product = 1;
        for(int j = l-1; j >= 0 ; j--) {
            res[j] = res[j]*product;
            product *= nums[j];
        }
         return res;
    }
}  
