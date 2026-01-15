class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return f(s,rev);
        
    }
    public int f(String s , String r){
        int n = s.length();
        // int m = r.length();
        //   int dp[][]= new int[n+1][n+1];
        // for(int row[]: dp)
        // Arrays.fill(row,-1);
        // for(int i=0;i<=n;i++)
        // dp[i][0]=0;
        // for(int i=0;i<=n;i++)
        // dp[0][i]=0;
        int prev[] = new int[n+1];
        int curr[] = new int[n+1];

      
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==r.charAt(j-1))
                //  dp[i][j]=1+dp[i-1][j-1];
                curr[j] = 1 + prev[j-1];
                else
                //  dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                curr[j] = Math.max(prev[j],curr[j-1]);

            }
            prev= curr.clone();
        }
        return prev[n];
    }
}