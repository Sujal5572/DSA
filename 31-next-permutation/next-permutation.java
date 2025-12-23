class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        //here we are finding the dip from index n-1 to 0
        while(i>=0 && nums[i]>=nums[i+1]){
        i--;
    }
     // we get the index i where there is dip
     //if last max permu is there then we will get i=-1 and then we can just reverse the number
    if(i>=0){
    int j=nums.length-1;
    while(j>=0 && nums[j]<=nums[i] )j--;
    // we get the index of number just greater than nums[i]

    // swap the number at i and j index
    swap(nums,i,j);
    }

    // after swaping we need to reverse the remaining part of nums i.e from i+1 to n-1
    reverse(nums,i+1);
    }
    static void swap(int nums[], int i ,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    static void reverse(int nums[],int start){
        int end = nums.length-1;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }

    }
}