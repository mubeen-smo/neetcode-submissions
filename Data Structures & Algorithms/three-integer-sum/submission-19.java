class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int size = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            if( i > 0 && nums[i-1] == nums[i]) continue;
            
            int j = i+1;
            int k = size - 1; 
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    result.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }

        }


        return result;


    }
}
