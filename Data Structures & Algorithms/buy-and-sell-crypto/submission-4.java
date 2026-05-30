class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int leastSoFar = prices[0];
        for(int n : prices) {
            int currProfit = n - leastSoFar;
            if(currProfit > 0) {
                profit = Math.max(profit,currProfit);
            }
            leastSoFar = Math.min(leastSoFar, n);
        }

        return profit;
    }
}
