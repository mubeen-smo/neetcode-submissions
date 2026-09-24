class Solution {
    public int maxProfit(int[] prices) {
        int leftMin = Integer.MAX_VALUE;

        int maxProfit = 0;

        for(int p : prices) {
            if(p - leftMin > 0) {
            maxProfit = Math.max(maxProfit, p - leftMin);
            }
            leftMin = Math.min(leftMin, p);
        }

        return maxProfit;
    }
}
