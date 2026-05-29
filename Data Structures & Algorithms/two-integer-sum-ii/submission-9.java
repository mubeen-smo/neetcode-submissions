class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if(numsMap.containsKey(diff)) {
                return new int[]{numsMap.get(diff) + 1, i + 1};
            }
            numsMap.put(numbers[i],i);
        }
        return new int[]{};
    }
}
