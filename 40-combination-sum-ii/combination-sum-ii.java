class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // tc will be O(2^n) as we are generating all the combination
        // sc will be O(n) recursion stack space.
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        help(0,candidates, target , ans , new ArrayList<>());
        return ans;
        
    }
    public void help(int ind, int c[], int t , List<List<Integer>> ans , List<Integer> part){
        if(t ==0){
        ans.add(new ArrayList<>(part));
        return;
        }
        if(t<0)
        return;
        for(int i = ind ;i<c.length;i++){
            if(i>ind && c[i]==c[i-1])continue;
            if(c[i]>t)break;
            part.add(c[i]);
            help(i+1,c,t-c[i],ans , part);
            part.remove(part.size()-1);
        }
    }
}