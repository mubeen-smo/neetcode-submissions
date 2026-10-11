class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int p : piles) {
            r = Math.max(r, p); // find the max pile size
        }
        
        int k = r;
        while (l <= r) {
            int rate = l + (r - l) / 2;
            if (canFinish(piles, rate, h)) {
                k = rate;       // try a smaller speed
                r = rate - 1;
            } else {
                l = rate + 1;   // need a faster speed
            }
        }
        return k;
    }

    private boolean canFinish(int[] piles, int rate, int h) {
        long totalHours = 0;
        for (int p : piles) {
            // Ceiling division: (p + rate - 1) / rate
            totalHours += (p + rate - 1) / rate;
            if (totalHours > h) return false; // early exit optimization
        }
        return totalHours <= h;
    }
}
