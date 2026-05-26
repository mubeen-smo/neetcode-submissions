class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        int longest = 0;
        for(int n : nums) {
            numsSet.add(n);
        }

        for(int n : nums) {
            if(numsSet.contains(n-1)) continue;
            int i = 1;
            while(numsSet.contains(n+i)) {
                i++;
            }
            if( i > longest) longest = i;
        }
        return longest;
    }
}
