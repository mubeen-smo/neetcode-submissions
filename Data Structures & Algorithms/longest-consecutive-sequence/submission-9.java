class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> numSet= new HashSet<>();

        for(int n : nums) {
            numSet.add(n);
        }

        int longest = 0;

        for(int d : numSet) {
            if(numSet.contains(d - 1)) continue;
            int currMax = 1;
            while(numSet.contains(++d)) {
                currMax++;
            }
            longest = Math.max(currMax, longest);
        }

        return longest;
    }
}
