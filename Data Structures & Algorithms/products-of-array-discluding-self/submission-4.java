class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;

        int[] left = new int[l];
        int[] right = new int[l];
        int[] res = new int[l];
        left[0] = 1;
        right[l-1] = 1;

        for(int i = 1; i < l ; i++) {
                left[i] = left[i-1]*nums[i-1];
        }
        for(int j = l-2; j >= 0 ; j--) {
            right[j] = right[j+1]*nums[j+1];
        }

        for(int i = 0; i < l ; i++) {
            res[i] = left[i]*right[i];
        }
        return res;
    }
}  
