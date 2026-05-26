class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int[] product = new int[size];
        product[0] = 1;
        
        for(int i = 1 ; i < size ; i++) {
            product[i] = product[i-1]*nums[i-1];
            System.out.println(product[i]);
        }
        int[] rightProduct = new int[size];
        rightProduct[size-1] = 1;
        for(int i = size-2 ; i >= 0 ; i--) {
            rightProduct[i] = rightProduct[i+1]*nums[i+1];
            System.out.println(i + ": " + rightProduct[i]);
        }

        for(int i = 0; i < size ; i++) {
            product[i] = product[i]*rightProduct[i];
        }
        
        return product;
    }
}  
