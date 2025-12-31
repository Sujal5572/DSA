class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int n= nums.length;
        while(i<j){
            int mid = i + (j - i)/2;
            if(mid %2!=0)
            mid--;
            if(nums[mid]== nums[mid+1]){ // single ele will be on right side as pair get broken
                i = mid+2;
            }
            else
            j= mid;
        }
        return nums[i];
    //     if(n==1 || nums[0]!=nums[1])
    //     return nums[0];
    // while(i<j){
    //     if(nums[i]!=nums[i+1]){
    //         return nums[i];
    //     }
    //     if(nums[j]!=nums[j-1])
    //     return nums[j];
    //     i+=2;
    //     j-=2;
    // }
    // return 0;
        
    }
}