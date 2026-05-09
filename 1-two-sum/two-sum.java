class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target - nums[i])){
                return new int[]{m.get(target-nums[i]),i};
            }
            m.put(nums[i],i);
        }
        return new int[]{};
    }
}
       
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target)
        //         {
        //             ans[0]=i;
        //             ans[1]=j;
        //         }
        //     }
        // }
        // return ans;
        