public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); 
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] candidates, int remain, int start) {
        if (remain == 0) {
            res.add(new ArrayList<>(cur)); 
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) {
                break; 
            }

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; 
            }

            cur.add(candidates[i]);
            backtrack(res, cur, candidates, remain - candidates[i], i + 1); 
            cur.remove(cur.size() - 1); 
        }
    }
}
