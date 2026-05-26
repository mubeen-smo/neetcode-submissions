class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int maxRate = piles[n-1];
        if(h == n) return maxRate;
        else {
            int l = 1;
            int r = maxRate;
            int res = maxRate;
            while(l <= r) {
            long totalTime = 0;
            int k = (l+r) / 2;
            for(int p : piles) {
                totalTime+= Math.ceil((double) p/k);
            }
            if(totalTime <= h) {
                res = k;
                r = k-1;
            } else {
                l = k+1;
            }
            }
            return res;
        }
    }
}
