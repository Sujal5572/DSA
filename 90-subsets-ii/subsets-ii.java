class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

         List<List<Integer>> ans = new ArrayList<>();
         int n = nums.length;
         List<Integer> part = new ArrayList<>();
         Arrays.sort(nums);
         help(0,n,ans,new ArrayList<>(),nums);
         return ans;
    }
    public void help(int ind , int n , List<List<Integer>> ans , List<Integer> part, int nums[]){
        ans.add(new ArrayList<>(part));
        for(int i= ind ; i< n;i++){
            if(i!= ind && nums[i]==nums[i-1])
            continue;
            part.add(nums[i]);
            help(i+1 , n , ans , part,nums);
            part.remove(part.size()-1);
        }
    }
}