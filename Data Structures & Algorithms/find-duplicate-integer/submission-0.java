class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums);
        Integer p = null;
        for(int n : nums) {
            if(p != null) {
                if(p == n) return p;
            }
            p = n;
        }
        return 0;
    }
}
