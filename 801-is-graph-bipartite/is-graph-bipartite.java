class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int col[]= new int[n];
        Arrays.fill(col,-1);
        // int currColor =0;
        for(int i=0;i<n;i++){
            if(col[i]==-1){
                // if(!bfs(graph,i,col))
                if(!dfs(graph ,i ,col, 0))
                return false;
            }
        }
        return true;
        
    }
    // bfs 
static boolean dfs(int g[][],int start, int col[], int currColor){
    col[start]= currColor;
    for(int neigh: g[start]){
        if(col[neigh]==-1)
        {
            if(!dfs(g,neigh,col,1-currColor))
            return false;
        }
        else if(col[neigh]==currColor){
        return false;
        }
    }
    return true;
}








    // tc = O(V + E)
// sc  = O(n);
    // static boolean bfs(int g[][], int start, int col[]){
    //     col[start]=0;
    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(start);

    //     while(!q.isEmpty()){
    //         int node = q.poll();
    //         for(int neigh : g[node]){
    //             if(col[neigh]==-1){
    //                 col[neigh]=1-col[node];
    //                 q.offer(neigh);
    //             }
    //             else if(col[neigh]==col[node])
    //             return false;
    //         }
    //     }
    //     return true;
    // }




}
