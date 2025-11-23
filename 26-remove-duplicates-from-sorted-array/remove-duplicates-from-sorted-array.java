class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=0;
        int j=1;
        while(j<n){

            if(nums[i]!=nums[j]){ // if not same then store value at j to i index and then i++
            i++;
            nums[i]=nums[j];
            }
            j++;
        }
        return i+1;
        // int c =0;
        // for(int i=0;i<n;i++){
        //     if(i<n-1 && nums[i]==nums[i+1]  )
        //     continue;
        //     nums[c]=nums[i];
        //     c++;
        // }
        // return c;


        // Set<Integer> s = new HashSet<>();
        // for(int i=0;i<nums.length;i++)
        // s.add(nums[i]);
        // return s.size();
    }
}