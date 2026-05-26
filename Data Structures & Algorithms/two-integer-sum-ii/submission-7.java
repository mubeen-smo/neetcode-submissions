class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i = 0; i < size ; i++) {
            int difference = target - numbers[i];
            if(numsMap.containsKey(difference)) {
                return new int[]{numsMap.get(difference)+1, i+1};
            }
            numsMap.put(numbers[i],i);
        }
        return new int[]{};
    }
}
