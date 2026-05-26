class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i < len ; i++) {
            if(nums[i] > 0) break;
            if(i > 0) if(nums[i] == nums[i-1]) continue;
            int r = len-1;
            int l = i+1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                System.out.println(nums[i] + "+" + nums[l] + "+"+ nums[r]);
                if(sum < 0) l++;
                else if(sum > 0) r--;
                else {
                    res.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                }
            }
        }

        return res;
    }
}
