class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m= obstacleGrid[0].length;
        int dp[][] = new int[n+1][m+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return solve(n-1 , m-1 , dp , obstacleGrid);
        
    }
    int solve(int i , int j , int dp[][], int mat[][]){
        if(i>=0 && j >=0 && mat[i][j]==1 || i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==0 && j ==0)return 1;
        return dp[i][j] = solve(i-1 , j,dp,mat) + solve(i , j-1 , dp, mat);
    }
}