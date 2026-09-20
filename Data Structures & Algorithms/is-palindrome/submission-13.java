class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> numSet= new HashSet<>();

        for(int n : nums) {
            numSet.add(n);
        }

        int longest = 0;

        for(int i = 0; i < nums.length; i++ ) {
            if(numSet.contains(nums[i] - 1)) continue;
            int d = nums[i];
            int currMax = 1;
            while(numSet.contains(++d)) {
                currMax++;
            }
            longest = Math.max(currMax, longest);
        }

        return longest;
    }
}
