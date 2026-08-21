class Solution {
    public int maxProfit(int[] prices) {
        // Key Logic -> Buy before Sell
        int n=prices.length;
        int profit=0;
        int maxProfit=0;

        int buy=prices[0]; // We have to minimize the buying value
        for(int i=0;i<n;i++){
            profit = prices[i] - buy;
            maxProfit = Math.max(profit, maxProfit); // maximize the profit
            buy = Math.min(buy, prices[i]);
        }
        return maxProfit;
    }
}