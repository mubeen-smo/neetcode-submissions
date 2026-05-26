class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for(int n : nums) {
            numSet.add(n);
        }

        int l = nums.length;
        int streak = 0;
        int longest = 0;
        for(int n : nums) {
            if(!numSet.contains(n-1)) {
                for(int i = 0; i < l; i++) {
                    if(numSet.contains(n+i)) {
                        streak++;
                    } else break;
                }
                if(streak > longest) longest = streak;
                streak = 0;
            }
        }

        return longest;
    }
}
