class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0)return 0;
        if(n==1)return nums[0];
        int dp1[]= new int[n+1];
        int dp2[]= new int[n+1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        //here 2 case 0 to n-2 and 1 to n-1;
        return Math.max(solve(nums ,0 ,n-2,dp1),solve(nums,1,n-1,dp2));
        
    }
    public int solve(int nums[],int start , int end,int dp[]){
        if(end<start)return 0;
        if(start == end)return nums[start];
        if(dp[end]!=-1)return dp[end];
        int pick = nums[end]+ solve(nums,start ,end-2,dp);
        int notpick = solve(nums,start, end-1,dp);
        return dp[end] = Math.max(pick , notpick);
    }
}