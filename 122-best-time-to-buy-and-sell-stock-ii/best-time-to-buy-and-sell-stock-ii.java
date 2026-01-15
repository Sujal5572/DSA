class Solution {
    public int maxProfit(int[] prices) {
//         return solve(0,0,prices);
//     }
//     // tc O(2^n)either buy or sell
//     // 
//     public int solve(int day , int holding , int prices[]){
//         if(day == prices.length )return 0;
//         if(holding ==0){// buy n skip
//         int buy = - prices[day] + solve(day +1 , 1 , prices);
//         int skip = solve(day + 1 , 0 , prices);
//         return Math.max(buy , skip);
//         }
//         else {
//             int sell = prices[day] + solve(day +1 , 0 , prices);
//             int skip = solve(day + 1 , 1 , prices);
//             return Math.max(sell , skip);
//         }
//     }
// }






        // sc O(1)
        int profit =0;
        int n = prices.length;
        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1])
            profit += prices[i] - prices[i-1];
        }
        return profit;
        
    }
}