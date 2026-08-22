class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> subset, int i) {
        if(i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(nums, subset, i+1);
        subset.remove(subset.size() - 1);
        if(subset.size() > 0 && nums[i] == subset.getLast()) {
            return;
        }
        backtrack(nums, subset, i+1);
    }
}
