class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i : nums)
        sum+=i;
        if(sum%2 !=0)return false;
        int n = nums.length;
        int k = sum/2;
        Boolean dp[][]= new Boolean[n][k+1];
        return solve(n-1,k, nums,dp);
    }
    boolean solve(int i , int k , int nums[] , Boolean dp[][]){
        if(i==0)return nums[i]==k;
        if(k< 0 || i<=0)return false;
        if(dp[i][k]!=null)return dp[i][k];
        boolean not_pick = solve(i-1 , k,nums,dp);
        boolean pick = false;
        if(nums[i]<= k){
            pick = solve(i-1,k-nums[i],nums,dp);
        }
        return dp[i][k] = pick || not_pick;
    }
}