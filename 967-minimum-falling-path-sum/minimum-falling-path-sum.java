class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //tabulation
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][]= new int[n][m];
       
        for(int i=0;i<m;i++){
            dp[0][i]=matrix[0][i]; // storing the 1st row values 
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up = dp[i-1][j]; // taking the values from the 1st row
                int left = (j>0)?dp[i-1][j-1]:(int)1e9;
                int right = (j<m-1)?dp[i-1][j+1]:(int)1e9;
                
                dp[i][j] = Math.min(up,Math.min(left,right)) + matrix[i][j];
                
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            mini = Math.min(mini,dp[n-1][i]);
        }
    return mini;
    }
}


//         int res = Integer.MAX_VALUE;
//         for(int i=0;i<m;i++){
//             res = Math.min(res,f(n-1,i,dp,matrix));

//         }

//     return res;
//     }
//     int f(int i, int j, int dp[][], int mat[][]){
//         if(j<0 || j>=mat[i].length)return Integer.MAX_VALUE; // 1e9
//         if(i==0 )return dp[i][j]=mat[0][j];
//         if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
//         int up= f(i-1,j,dp,mat);
//         int left = f(i-1,j-1,dp,mat);
//         int right = f(i-1,j+1,dp,mat);
//         return dp[i][j]= Math.min(Math.min(up,left),right) + mat[i][j];
//     }
// }