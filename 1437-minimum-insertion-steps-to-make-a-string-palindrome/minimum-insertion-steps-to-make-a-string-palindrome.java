class Solution {
    public int minInsertions(String s) {
       String s2 = new StringBuilder(s).reverse().toString(); 
       int n = s.length();
    //    int dp[][]= new int[n+1][n+1];

       // mbadm --> lps -> mbm/mam/mdm
       // so no. insertion to make string palindrome will be n - length of lcs
       // hence we are finding the lps

       int prev[] = new int[n+1];
       int curr[] = new int[n+1];


       // here we find lps
       for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(s.charAt(i-1)==s2.charAt(j-1))
            // dp[i][j]= 1+ dp[i-1][j-1];
            curr[j] = 1 + prev[j-1];
            else
            // dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            curr[j] = Math.max(curr[j-1],prev[j]);
        }
        prev = curr.clone();
       }
        // return n-dp[n][n];
        return n - prev[n];
    }
}