class Solution {
    public boolean canPartition(int[] nums) {
         int totalsum = 0;
        for(int x: nums)
        totalsum+=x;
        if(totalsum % 2==1)return false;
        int n = nums.length;
        int k = totalsum/2;
        boolean dp[]= new boolean[k+1];
        dp[0]=true;
        for(int i : nums){
            for(int j=k ;j>=i ;j--){
                dp[j] = dp[j] || dp[j-i]; // for i=1 ->[t,t,f......f(11)]
                // for i=5 [t,t,f,f,f,t,t,f...]
            }
        }
        return dp[k];
    }
}



//         // tc O(n*k) and sc O(n*k)for dp and O(n)for recursion stack space;
//         int totalsum = 0;
//         for(int x: nums)
//         totalsum+=x;
//         if(totalsum % 2==1)return false;
//         int n = nums.length;
//         int k = totalsum/2;
//         Boolean dp[][]= new Boolean[n][k+1];
//         return help(0,nums,k,dp);
        
//     }
//     static boolean help(int i , int num[],int k , Boolean dp[][]){
//         int n = num.length;
//         if(k==0)return true;
//         if(k< 0 || i >= n)return false;
//         if(dp[i][k]!=null)
//         return dp[i][k];
//         if(k==0)return true;
//         boolean notpick = help(i+1, num,k , dp); 
//         boolean pick = false;
//         if(num[i]<=k)
//         pick = help(i+1,num , k-num[i],dp);
//         return dp[i][k] = pick || notpick;
//     }
// }