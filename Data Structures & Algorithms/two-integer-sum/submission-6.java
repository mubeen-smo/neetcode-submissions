class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(numsMap.containsKey(diff)) {
                return new int[]{numsMap.get(diff), i};
            }
            numsMap.put(nums[i],i);
        }
        return new int[]{};

    }
}
