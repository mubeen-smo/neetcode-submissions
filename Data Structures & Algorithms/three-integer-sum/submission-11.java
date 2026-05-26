class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int size = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i < size; i++) {
            int a = nums[i];
            if(a > 0) break;
            if(i > 0) if(a == nums[i-1]) continue;
            int j = i+1;
            int k = size-1;
            while(j < k) {
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;
                if(sum < 0) j++;
                else if(sum > 0) k--;
                else {
                    res.add(new ArrayList<>(Arrays.asList(a,b,c)));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
         }
            return res;

    }
}
