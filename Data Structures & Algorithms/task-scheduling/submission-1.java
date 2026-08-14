class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] f = new int[26];
        for (char c : tasks) {
            f[c - 'A']++;
        }
        int hf = 0;
        int maxCount = 0;
        for (int e : f) {
            if (hf <= e) {
                if (hf == e) maxCount++;
                else {
                    hf = e;
                    maxCount = 1;
                }
            }
        }
        int result = (hf - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, result);
    }
}
