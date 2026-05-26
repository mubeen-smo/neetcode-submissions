class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int size = numbers.length;
        
        for(int i = 0; i < size ; i++) {
            int n = numbers[i];
            int difference = target-n;

            if(numsMap.containsKey(difference)) {
                
                return new int[]{numsMap.get(difference)+1, i+1};
            }
            numsMap.put(numbers[i],i);
        }
        return new int[]{};
    }
}
