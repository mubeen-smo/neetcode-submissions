class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(int[] candidates, int target, int i, List<Integer> combination, int total) {
        if(total == target) {
            res.add(new ArrayList<>(combination));
            return;
        }
        if(total > target || i == candidates.length) {
            return;
        }
        combination.add(candidates[i]);
        dfs(candidates, target, i+1, combination, total + candidates[i]);
        combination.remove(combination.size() - 1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        };
        dfs(candidates, target, i+1, combination, total);
    }
}
