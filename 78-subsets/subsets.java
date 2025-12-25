class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // here tc O(2^n. n) 2^n for recursive call s and n for creating a new copy of curr and sc O(n)
    //     List<List<Integer>> ans = new ArrayList<>();
    //     solve(0,nums, ans, new ArrayList<>());
    //     return ans;
    // }
    // public void solve(int i , int nums[],List<List<Integer>> ans , List<Integer> curr){
    //     if(i == nums.length){
    //     ans.add(new ArrayList<>(curr));
    //     return;
    //     }

    //     curr.add(nums[i]);
    //     solve(i+1,nums,ans,curr);
    //     curr.remove(curr.size()-1);
    //     solve(i+1,nums,ans,curr);
    // }



// here tc is O(2^n .n)here outer loop runs for 2^n times and inner for n and sc O(1)
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int k =1<<n; // here 1 left of n is 2^n we are finding this to calculate the number  of    subsets
        for(int i=0;i<k;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0) // if bit is set at that index then we are going to add ele
                temp.add(nums[j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
