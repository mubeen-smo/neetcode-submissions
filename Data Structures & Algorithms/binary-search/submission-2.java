class Solution {
    public int search(int[] nums, int target) {
        
        int size = nums.length;

        int l = 0, r = size-1;

        while(l <= r) {
            int m = nums[(l+r)/2];

            if(m < target) {
                l = (l+r)/2 + 1;
            } 
            else if(m > target) {
                r = (l+r)/2 - 1;
            }
            else return (l+r)/2;
        }
        return -1;
    }
}
