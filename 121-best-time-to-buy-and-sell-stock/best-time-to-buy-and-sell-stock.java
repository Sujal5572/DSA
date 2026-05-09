class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        int mini = prices[0];
        for(int price : prices){
            int cost  = price - mini;
            profit = Math.max(profit , cost);
            mini = Math.min(mini , price);
        }
        return profit;
        //tc = O(n) as we are traversing the whole array once.
    }
}



//         int profit =0;
//         int mini= prices[0];
//         int n = prices.length;
//         for(int i=0;i<prices.length;i++){
//            int cost = prices[i]- mini;
//            profit= Math.max(cost,profit);
//            mini = Math.min(mini,prices[i]);
//         }
//         return profit;
//     }
// }