class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int n : nums) {
            numSet.add(n);
        }
        int max = 0;
        for(int n : nums) {
            if(!numSet.contains(n-1)) {
                int i = 1;
                int count = 1;
                while( i < nums.length && numSet.contains(n+i)) {
                    count++;
                    i++;
                }
                max = Math.max(count,max);
            }
        }
        return max;
    }
}
