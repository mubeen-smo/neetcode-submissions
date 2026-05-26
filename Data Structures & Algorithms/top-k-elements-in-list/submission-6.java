class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        int size = nums.length+1;
        List<Integer>[] bucket = new List[size];

        Map<Integer, Integer> freqMap = new HashMap();
        for(int n : nums) {
            int f = freqMap.getOrDefault(n, 0);
            freqMap.put(n, f+1);
        }
        freqMap.forEach((key,v) -> System.out.println(key + " : " + v));

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        int j = 0;
        for(List<Integer> b : bucket) {
            System.out.println(j++ + " -> " + b);
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = size-1; i > 0 && index < k ; i--) {
            if(bucket[i] != null) {
                for(int n : bucket[i]) {
                    res[index++] = n;
                    if(index == k) return res;
                }
            }
        } 
        return res;
    }
}
