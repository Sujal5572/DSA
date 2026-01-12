class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        // int dp[][] = new int[n][target+1];
        return solve(n-1 , nums ,0, target);
        
    }
    public int solve(int n , int nums[] ,int sum , int target ){
        if(n<0)
        return target == sum? 1:0;
        int add = solve(n-1 , nums , sum + nums[n], target );
        int sub = solve(n-1 , nums , sum - nums[n] ,target);
        return add + sub;
    }
}