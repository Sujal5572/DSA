class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max_profit = 0;
        for(int i : prices){
            min = Math.min(i,min);
            int profit = i - min;
            max_profit = Math.max(profit , max_profit);

        }
        return max_profit;
        
    }
}