class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int[] leftProduct = new int[size];
        int[] rightProduct = new int[size];
        leftProduct[0] = 1;
        for(int i=1; i < size; i++) {
            leftProduct[i] = leftProduct[i-1]*nums[i-1];            
        }
        rightProduct[size-1] = 1;
        for(int i = size-2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i+1]*nums[i+1];
        }
        int[] result = new int[size];
        for(int i = 0; i < size; i++ ) {
            result[i] = leftProduct[i]*rightProduct[i];
        }
        return result;
    }
}  
