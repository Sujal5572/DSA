class Solution {
    public int numEnclaves(int[][] grid) {
        // here tc O(n*m)as we are checking for each unqiue element at once 
        // if constraint are large then we shift to bfs as to avoid recursion depth issue
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==1)
            dfs(i,0,grid);
            if(grid[i][m-1]==1)
            dfs(i,m-1,grid);
        }
             for(int i=0;i<m;i++){
            if(grid[0][i]==1)
            dfs(0,i,grid);
            if(grid[n-1][i]==1)
            dfs(n-1,i,grid);
        }
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                count++;
            }
        }


return count;
    }
    public void dfs(int i , int j , int b[][]){
        int n = b.length;
        int m = b[0].length;
        if(i<0 || j<0 ||i>=n||j>=m || b[i][j]!=1)return ;
        b[i][j] =0;
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        for(int k=0;k<4;k++){
            int nr = i + dr[k];
            int nc = j + dc[k];
            dfs(nr ,nc ,b);
        }
    }
}







//         if(n==0 || grid== null)return 0;
//         Stack<int[]> st = new Stack<>();
//         for(int i=0;i<n;i++){
//             if(grid[i][0]==1)
//             st.push(new int[]{i,0});
//             if(grid[i][m-1]==1)
//             st.push(new int[]{i,m-1});
//         }
//         for(int j=0;j<m;j++){
//             if(grid[0][j]==1)
//             st.push(new int[]{0,j});
//             if(grid[n-1][j]==1)
//             st.push(new int[]{n-1,j});
//         }
//         int dr[]={-1,0,1,0};
//         int dc[]={0,1,0,-1};

//         while(!st.isEmpty()){
//             int ceil[]= st.pop();
//             int x = ceil[0];
//             int y = ceil[1];
//             grid[x][y]=0;
//         for(int i=0;i<4;i++){
//             int r = x + dr[i];
//             int c = y + dc[i];
//             if(r>=0 && c>=0 && r<n && c <m && grid[r][c]==1)
//             st.push(new int[]{r,c});

//         }
//         }
//         int c =0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]==1)
//                 c++;
//             }
//         }
//         return c;
//     }
// }