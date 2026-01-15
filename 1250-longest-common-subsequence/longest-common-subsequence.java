class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // int dp[][]= new int[n+1][m+1];
        // for(int r[]:dp)
        // Arrays.fill(r,-1);
        // for(int i=0;i<=n;i++)
        // dp[i][0]=0;
        // for(int i=0;i<=m;i++)
        // dp[0][i]=0;
        int prev[]= new int[m+1];
        int curr[] = new int[m+1];



//1312
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)== text2.charAt(j-1))
                // dp[i][j]= 1 + dp[i-1][j-1];
                curr[j] = 1+prev[j-1];
                else
                // dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                curr[j] = Math.max(curr[j-1],prev[j]);
            }
            prev = curr.clone();
        }
        // return dp[n][m];
        return prev[m];
        
    }
}

// recursion
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         return solve(text1, text2, text1.length() - 1, text2.length() - 1);
//     }

//     private int solve(String text1, String text2, int i, int j) {
//         if (i < 0 || j < 0) {
//             return 0;
//         }
//         if (text1.charAt(i) == text2.charAt(j)) {
//             return 1 + solve(text1, text2, i - 1, j - 1);
//         } else {
//             return Math.max(solve(text1, text2, i - 1, j), solve(text1, text2, i, j - 1));
//         }
//     }
// }


// memo
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int[][] dp = new int[text1.length()][text2.length()];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return solve(text1, text2, text1.length() - 1, text2.length() - 1, dp);
//     }

//     private int solve(String text1, String text2, int i, int j, int[][] dp) {
//         if (i < 0 || j < 0) {
//             return 0;
//         }
//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         if (text1.charAt(i) == text2.charAt(j)) {
//             dp[i][j] = 1 + solve(text1, text2, i - 1, j - 1, dp);
//         } else {
//             dp[i][j] = Math.max(solve(text1, text2, i - 1, j, dp), solve(text1, text2, i, j - 1, dp));
//         }
//         return dp[i][j];
//     }
// }