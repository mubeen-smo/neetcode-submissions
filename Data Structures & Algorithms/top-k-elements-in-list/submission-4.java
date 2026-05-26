class Solution {
    public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> frequencyMap = new HashMap<>();

    for(int n : nums) {
        frequencyMap.put(n, frequencyMap.getOrDefault(n,0) + 1);
    }
    int l = nums.length;
    List<Integer>[] frequencyBucket = new List[l + 1];

    for(int n : frequencyMap.keySet()) {
        if(frequencyBucket[frequencyMap.get(n)] == null) {
            frequencyBucket[frequencyMap.get(n)] = new ArrayList<>();
        }
        frequencyBucket[frequencyMap.get(n)].add(n);
    }

    int[] res = new int[k];
    int index = 0;
    for(int i = l; i > 0 && index < k ; i--) {

        if(frequencyBucket[i] != null) {
        for(int n : frequencyBucket[i]) {
            res[index++] =  n;
            if(index == k ) return res;
            }
        }
    }

    return res;

    }
}
