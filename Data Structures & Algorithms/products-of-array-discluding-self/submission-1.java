class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int product = 1;
        int l = nums.length;
        int[] prefix = new int[l];
        int i = 0;
        for (int n : nums) {
            prefix[i++] = product;
            
            product = product*n;
        System.out.println(product + " ");
        }
        System.out.println(product);
        product = 1;
        int[] suffix = new int[l];
        for (int j = l-1; j >= 0; j--) {
            suffix[j] = product;
            product = product*nums[j];
        System.out.println(product + " ");
        }
        int[] output = new int[l];

        i = 0;
        for(int n : nums) {
            output[i] = prefix[i]*suffix[i];
            i++;
        }

        return output;
    }
}  
