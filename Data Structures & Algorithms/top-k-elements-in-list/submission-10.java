class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> fMap = new HashMap<>();

        for(int n : nums) {
            fMap.put(n, fMap.getOrDefault(n,0) + 1);
        }

        int size = nums.length;

        List<Integer>[] fStore = (List<Integer>[]) new List[size+1];

        for(int n : fMap.keySet()) {
            int f = fMap.get(n);

            if(fStore[f] == null) {
                fStore[f] = new ArrayList<>();
            }
            fStore[f].add(n);
        }

        int[] res = new int[k];
        int count = 0;
        for(int i = size; i >=0; i--) {
            if(!(fStore[i] == null)) {
                int j = 0;
                while(count < k && j < fStore[i].size() ) {
                    res[count++] = fStore[i].get(j++);
                }
            }
            if(count >= k) break;
        }
        return res;
    }
}
