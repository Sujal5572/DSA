class Solution {
     public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        // tc O(n*m)in worst case each pixel is visited once 
        // sc O(n*m)as we are taking queue in worst case have to store all the pixel
        int n = image.length;
        int m = image[0].length;

        int initialcolor = image[sr][sc];
        if(initialcolor == color)return image;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        image[sr][sc]= color;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};


        while(!q.isEmpty()){
            int cell[] = q.poll();
            int row = cell[0];
            int col = cell[1];
            for(int i=0;i<4;i++){
                int nr = row + drow[i];
                int nc = col + dcol[i];
                if(nr>=0 && nc>=0 && nr<n && nc <m && image[nr][nc]==initialcolor){
                    image[nr][nc] = color;
                    q.add(new int[]{nr,nc});
                }
            }

        }
        return image;

     }
}

//     static void dfs(int im[][],int sr, int sc,int newcol,int inicol){
      
//         int n = im.length;
//         int m = im[0].length;
//         if(sr<0 || sc<0 || sr>=n || sc>=m || im[sr][sc]!=inicol)
//         return;
//           im[sr][sc]=newcol;
//           int dr[]={-1,0,1,0};
//           int dc[]={0,1,0,-1};
//         for(int i=0;i<4;i++){
//             int r = sr +dr[i];
//             int c= sc + dc[i];
//             dfs(im,r,c,newcol,inicol);
//         }
//     }
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int inicol = image[sr][sc];
//         if(inicol!= color){
//             dfs(image,sr,sc,color,inicol);
//         }
//         return image;


//     }
// }