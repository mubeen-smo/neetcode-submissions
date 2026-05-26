class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Map<Integer, Integer> numsMap = new HashMap<>();
        int frequency = 0;
        for(int n: nums) {
            numsMap.put(n, numsMap.getOrDefault(n, 0) + 1);
            if(numsMap.getOrDefault(n, 0) > 1) return true;
        }
        return false;
    }
}