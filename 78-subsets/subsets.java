class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //tc will be O(n.2^n)as we generating 2^n subset and coping each subset take O(n) time
        // O(n) sc due to recursion stack space
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,nums , ans, new ArrayList<>());
        return ans;
    }
    public void solve(int i , int nums[], List<List<Integer>> ans,List<Integer> part){
        if(i == nums.length){
            ans.add(new ArrayList<>(part));
            return;
        }
        part.add(nums[i]);
        solve(i+1 , nums,ans, part);
        part.remove(part.size()-1);
        solve(i+1,nums,ans,part);

    }
}