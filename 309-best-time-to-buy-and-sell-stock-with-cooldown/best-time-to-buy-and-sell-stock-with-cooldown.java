class Solution {
    public int maxProfit(int[] prices) {

        // here tc O(n)
        // sc O(n)
        int n = prices.length;
        if(n==0)return 0;
        int hold[]= new int[n];
        int sell[]=new int[n];
        int rest[] = new int[n];

        hold[0] = -prices[0];
        sell[0]=0;
        rest[0]=0;
        for(int i=1;i<n;i++){
            hold[i]=Math.max(hold[i-1],rest[i-1] - prices[i]);//either we have bought yesterday or buy today only when we were resting yesterday;
            sell[i] = prices[i]+hold[i-1];// if we are holding then we should sell it
            rest[i] = Math.max(rest[i-1],sell[i-1]);// we are already rest or in cooldown yesterday(sold yesterday)

        }
        return Math.max(rest[n-1],sell[n-1]);
    }
}






    // tc O(n)as we are storing in 2d array so number of unique states is n*2;
    //O(n2) + O(n)
//     public int maxProfit(int[] prices) {
//         int dp[][] = new int[prices.length][2];
//         return solve(0,0,prices,dp);
        
//     }
//     public int solve(int day , int holding , int p[],int dp[][]){
//         if(day>=p.length)return 0;
//         if(dp[day][holding]!=0)return dp[day][holding];
//         int profit =0;
//         if(holding ==0){
//             int buy = -p[day] + solve(day + 1 , 1 , p,dp);
//             int skip = solve(day +1 ,0,p,dp );
//             profit= Math.max(buy , skip);
//         }
//         else{
//             int sell = p[day] + solve(day+2, 0 , p,dp);
//             int skip = solve(day+1 , 1 ,p,dp);
//             profit= Math.max(sell ,skip);
//         }
//         dp[day][holding]=profit;
//         return profit;
//     }
// }