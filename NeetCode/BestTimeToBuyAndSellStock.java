class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int min = prices[0];
        for(int i = 0; i < n; i++){
            int temp = prices[i];
            profit = Math.max(profit, temp - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
