

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int size = nums.length;
        int[] result = new int[k];
        List<Integer>[] buckets = new List[size+1];

        Map<Integer, Integer> fMap = new HashMap<>();

        for(int n : nums) {
           fMap.put(n, fMap.getOrDefault(n,0) + 1);
        }

        for(int n : fMap.keySet()) {
            int f = fMap.get(n);
            if(buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(n);
        }

        for(int i = size; i > 0; i--) {
            if(buckets[i] == null) continue;
            System.out.println(i + ":" + buckets[i].stream()
                                         .map(Object::toString) 
                                         .collect(Collectors.joining(" -> ")));
        }
        int resultIndex = 0;

        for(int i = size; i > 0; i--) {
            if(buckets[i] == null) continue;
            int listIndex = 0;
            while(resultIndex < k && listIndex < buckets[i].size()) {
                result[resultIndex++] = buckets[i].get(listIndex++);
            }
        }

        return result;

    }
}
