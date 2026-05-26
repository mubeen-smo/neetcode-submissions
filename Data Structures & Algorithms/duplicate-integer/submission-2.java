class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Set<Integer> containsNum = new HashSet<>();
        for(int n : nums) {
            if(containsNum.contains(n)) {
                return true;
            }
            containsNum.add(n);
        }
        return false;
    }
}