class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int zero =0;
        int maxZero = 0;
        for(int i : nums){
            if(i ==1){
                zero++;
                maxZero = Math.max(zero , maxZero);
            }
            else{
                zero=0;
                continue;
            }
        }
        return maxZero;
        // tc O(n)as we are traversing the whole array once
        //sc O(1)as we are not using extra space;
    }
}



