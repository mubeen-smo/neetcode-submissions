class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fMap = new HashMap<>();

        for(int n : nums) {
            fMap.put(n, fMap.getOrDefault(n,0) + 1);
        }
        
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int key : fMap.keySet()) {
            int fIndex = fMap.get(key);
            if(bucket[fIndex] == null) {
                bucket[fIndex] = new ArrayList<>();
            }
            bucket[fIndex].add(key);
        }
        int[] res = new int[k];
        int counter = 0;

        for(int i = bucket.length - 1; i > 0 && counter < k; i--) {
            if(bucket[i] != null) {
                for(int n : bucket[i]) {
                    res[counter++] = n;
                    if(counter == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}
