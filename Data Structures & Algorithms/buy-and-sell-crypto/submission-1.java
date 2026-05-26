class Solution {
    public int maxProfit(int[] prices) {

        int size = prices.length;
        int leastPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < size; i++) {
            if(maxProfit < (prices[i] - leastPrice)) {
                maxProfit = prices[i] - leastPrice;
            } 
            if(leastPrice > prices[i]) {
                leastPrice = prices[i];
            }
        }
        
        return maxProfit;
    }
}
