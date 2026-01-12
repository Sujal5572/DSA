class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][]= new int[n][amount+1];
        int INF = (int)1e9;
        for(int i=0;i<n;i++)
        dp[i][0]=0; // we can make amount without taking any coins
        for(int j=1;j<=amount;j++){
            // we can only make amount if it is divisible by coin[0]
            if(j%coins[0]==0) // 0th row will contians the number coins that are required to make that sum from 1 to amount ; 
                dp[0][j]=j/coins[0];
            else
                dp[0][j] = INF;

        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                // if we skip then we are going to pick from previous row
                int notpick = dp[i-1][j];

                int pick = INF;
                if(coins[i]<=j)
                // 1 + same row , previous amount
                pick = 1+ dp[i][j-coins[i]];
                dp[i][j] = Math.min(pick , notpick);
            }
        }
        int res = dp[n-1][amount];
        return res >= INF ? -1 : res;
    }
}






// tc O(2^n+amount) and sc(n*amount) + recursion stack space 
//         int res = solve(n-1 , coins , amount ,dp);
//         return res >= (int)1e9 ? -1 : res;
//     }
        
//     public int solve(int n , int coins[], int amount , int dp[][]){
//         if(amount ==0)return 0;
//         if(n<0 || amount<0)return (int)1e9;
//         if(dp[n][amount]!= 0)return dp[n][amount];
//         int notpick = solve(n-1 , coins , amount ,dp);
//         int pick = (int)1e9;
//         if(coins[n]<=amount)
//         pick = 1 + solve(n , coins , amount - coins[n],dp);
//         return dp[n][amount] = Math.min(pick , notpick);
//     }
    
// }



