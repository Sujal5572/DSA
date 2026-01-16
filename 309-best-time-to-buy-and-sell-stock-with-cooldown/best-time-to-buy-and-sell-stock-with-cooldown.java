class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        return solve(0,0,prices,dp);
        
    }
    public int solve(int day , int holding , int p[],int dp[][]){
        if(day>=p.length)return 0;
        if(dp[day][holding]!=0)return dp[day][holding];
        int profit =0;
        if(holding ==0){
            int buy = -p[day] + solve(day + 1 , 1 , p,dp);
            int skip = solve(day +1 ,0,p,dp );
            profit= Math.max(buy , skip);
        }
        else{
            int sell = p[day] + solve(day+2, 0 , p,dp);
            int skip = solve(day+1 , 1 ,p,dp);
            profit= Math.max(sell ,skip);
        }
        dp[day][holding]=profit;
        return profit;
    }
}