class Solution {
    public int longestConsecutive(int[] nums) {
        
        int maxLength = 0;
        Set<Integer> numSet = new HashSet<>();
        int size = nums.length;
        for(int n : nums) {
            numSet.add(n);
        }


        for(int n : nums) {
            if(!numSet.contains(n-1)) {
                int currFrequency = 0;
                int currNum = n;
                while(numSet.contains(currNum++)) currFrequency++;
                if(currFrequency > maxLength) maxLength = currFrequency;
            }
        }
        return maxLength;
    }
}
