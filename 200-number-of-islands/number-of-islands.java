class Solution {
    public int numIslands(char[][] grid) {
        if(grid ==null || grid.length==0)
        return 0;
        int n = grid.length;
        int m = grid[0].length;
        int Islands =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]=='1'){
                    Islands++;
                    dfs(i,j,grid);
                }
            }
        }
        return Islands;
        
    }
    static void dfs(int i, int j , char grid[][]){
        // // return if we move out of the grid or we encounter and 0 in the grid
        // if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] =='0')
        // return ;
        // //mark that part water which we traverse as land;
        // grid[i][j]='0';
        // dfs(i,j-1,grid);
        // dfs(i-1,j,grid);
        // dfs(i,j+1,grid);
        // dfs(i+1,j,grid);


        // using recursive dfs we can just further optimized it as it manage the depth of   search    without risking a stack overflow.
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{i,j});
        while(!st.isEmpty()){
            int pos[]=st.pop();
            int x = pos[0];
            int y = pos[1];

            if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] =='0')
             continue ;
            
            grid[x][y]='0';
            st.push(new int[]{x,y-1});
            st.push(new int[]{x-1,y});
            st.push(new int[]{x,y+1});
            st.push(new int[]{x+1,y});
        }


    }
}