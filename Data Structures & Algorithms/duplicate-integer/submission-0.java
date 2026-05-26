class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashMap<Integer,Integer> countMap = new HashMap<>();

       for(int i = 0; i < nums.length; i++) {
            if(countMap.get(nums[i]) != null) return true;

            else countMap.put(nums[i],1);
       } 
       return false;
    }
}