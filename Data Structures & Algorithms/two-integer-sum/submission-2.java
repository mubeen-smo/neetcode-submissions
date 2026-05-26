class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int difference = 0;
        Map<Integer, Integer> numsMap = new HashMap<>();

       for(int i = 0; i < nums.length ; i++) {

            difference = target - nums[i];

            if(numsMap.containsKey(difference)) {
                return new int[] {numsMap.get(difference),i};
            }
            numsMap.put(nums[i], i);
       }
       return new int[] {0};
    }
}
