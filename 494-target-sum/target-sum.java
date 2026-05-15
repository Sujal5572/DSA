class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //recursive O(2^n) due to + and -
        //mem O(n*sum) as total n* 2000 states present here
        int n = nums.length;
        int dp[][] = new int[n][2001]; // as sum is from -1000 to 1000 so total range = 2000
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,0,nums,target,dp);
    }
    public int solve(int i , int sum , int nums[], int target,int dp[][]){
        if(i == nums.length){
            if(sum == target)return 1;
            return 0;
        }
        int shifted = sum + 1000;
        if(dp[i][shifted]!= -1)return dp[i][shifted];

        int plus = solve(i+1 , sum + nums[i],nums,target,dp);
        int minus = solve(i+1,sum-nums[i],nums,target,dp);
        return dp[i][shifted]=plus + minus;
    }
}



        // tc O(n*S)
        // sc O(S+1)

//         int n = nums.length;
//         int total =0;

//         for(int num : nums)
//         total += num;
        
//         if(Math.abs(target)> total || (target + total)%2 != 0)//P = sum of + and N = sum of -
//         return 0; //p+n = total sum and p-n = target adding both it should nit be fraction

//         int S = (total + target)/2; // how many subset can have this so here we solved

//         int dp[] = new int[S + 1];
//         dp[0]=1;
//         for(int num : nums){
//             for(int j= S ; j>=num ;j--){
//                 dp[j] += dp[j-num];
//             }
//         }
//         return dp[S];
//     }
// }





// tc will be O(n * (2TS))as for each inique combi we are running sum 
//sc will be O(n * ts )+O(n)for recursion
//     int dp[][];
//     int offset; // as we cant have negative index so that we are using offset  actual sum(-6) index -6 +6=0
//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;
//         int total = 0;

//         for(int num : nums) total+= num;
//         dp = new int[n][2*total + 1]; // due(-ts ... ts)range

//         if(Math.abs(target)>total )return 0;

//         for(int i=0;i<n;i++)
//         Arrays.fill(dp[i],Integer.MIN_VALUE); // as we mark it invalid
//         offset = total;
//         // int dp[][] = new int[n][target+1];
//         return solve(n-1 , nums ,0, target);
        
//     }
//     public int solve(int n , int nums[] ,int sum , int target ){
//         if(n<0)
//         return target == sum? 1:0;
//         if(dp[n][offset + sum]!=Integer.MIN_VALUE)return dp[n][offset + sum];

//         int add = solve(n-1 , nums , sum + nums[n], target );
//         int sub = solve(n-1 , nums , sum - nums[n] ,target);
//         return dp[n][offset + sum] = add + sub;
//     }
// }