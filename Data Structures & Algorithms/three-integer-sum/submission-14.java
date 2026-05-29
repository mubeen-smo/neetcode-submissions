class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < size; i++ ) {
            if(nums[i] > 0) continue;
            if(i > 0) {
                if( nums[i] == nums[i-1]) continue;
            }
            int j = i+1;
            int k = size-1;

            while(j < k) {
                if(j > i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0) {
                    List<Integer> each = new ArrayList<>();
                    each.add(nums[i]);
                    each.add(nums[j]);
                    each.add(nums[k]);
                    result.add(each);
                    j++; k--;
                } 
                else if (sum < 0) j++;
                else k--;
            }
        }
        return result;
    }
}
