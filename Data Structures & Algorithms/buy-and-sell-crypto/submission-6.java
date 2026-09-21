class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int leftMin = Integer.MAX_VALUE;

        for(int p : prices) {
            if(p > leftMin) {
                maxProfit = Math.max(maxProfit, p - leftMin);
            }
            leftMin = Math.min(leftMin, p);
        }
        return maxProfit;
    }
}
