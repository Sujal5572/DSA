class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // here tc will be (n.2^n) as we are generating all the subset and since we are checking for duplicay we need to touch every ele once . hence n.2^n
        // sc will be O(n.2^n) as there are n ele for each subset
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n =nums.length;
        help(0,n,nums,ans,new ArrayList<>());
        return ans;
    }
    public void help(int start , int n , int nums[],List<List<Integer>> ans , List<Integer> part){
        ans.add(new ArrayList<>(part));
        for(int i =start ;i<n;i++){
            if(i>start && nums[i-1]== nums[i])continue;
            part.add(nums[i]);
            help(i+1 , n , nums , ans , part);
            part.remove(part.size()-1);
        }
    }
}


//          List<List<Integer>> ans = new ArrayList<>();
//          int n = nums.length;
//          List<Integer> part = new ArrayList<>();
//          Arrays.sort(nums);
//          help(0,n,ans,new ArrayList<>(),nums);
//          return ans;
//     }
//     public void help(int ind , int n , List<List<Integer>> ans , List<Integer> part, int nums[]){
//         ans.add(new ArrayList<>(part));
//         for(int i= ind ; i< n;i++){
//             if(i!= ind && nums[i]==nums[i-1])
//             continue;
//             part.add(nums[i]);
//             help(i+1 , n , ans , part,nums);
//             part.remove(part.size()-1);
//         }
//     }
// }