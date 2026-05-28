class Solution {
    public boolean canJump(int[] nums) {
        int maxInd =0;
        for(int i=0;i<nums.length;i++){
            if(i>maxInd) // we are unable to reach the index that beyond maxInd
            return false;
            maxInd = Math.max(maxInd , i + nums[i]);
        }
        return true;
    }
}