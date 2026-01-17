class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[]=new int[n];
        int parent [] = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++)
        parent[i] =i;
        int maxlen = 1;
        int lastIndex = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]% nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                    parent[i]=j;// Mark j as the 'previous' element of i
                }
            }
            if(dp[i]>maxlen){
                maxlen = dp[i];// Update global max length
                lastIndex = i; // Store this index to start backtracking later
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(parent[lastIndex]!=lastIndex){
            ans.add(nums[lastIndex]);//add current element to the answer
            lastIndex = parent[lastIndex];// Move to the previous element in the sequence
        }
        ans.add(nums[lastIndex]);
        Collections.reverse(ans);
        return ans;
        
    }
}