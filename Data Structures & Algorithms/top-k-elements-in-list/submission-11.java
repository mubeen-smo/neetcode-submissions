class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int n : nums) {
           frequencyMap.put(n ,frequencyMap.getOrDefault(n, 0) + 1);
        }

        int size = nums.length;

        List<Integer>[] bucket = (List<Integer>[]) new List[size+1];

        for(int n : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(n);

            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(n);
        }

        int[] result = new int[k];
        int count = 0;
        for(int i = size; i > 0 && count < k; i--) {
            if(bucket[i] != null) {
                int j = 0;
                while(j < bucket[i].size() && count < k) {
                    result[count++] = bucket[i].get(j++);
                }
            }
            if(count >= k) return result;
        }
        return result;
    }
}
