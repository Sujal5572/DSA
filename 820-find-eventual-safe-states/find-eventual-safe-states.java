class Solution {
    public boolean dfs(List<List<Integer>> adj, int src, boolean[] vis, boolean[] recst) {
        vis[src] = true;
        recst[src] = true;
        for (int x : adj.get(src)) {
            if (!vis[x] && dfs(adj, x, vis, recst)) {
                return true;
            } else if (recst[x]) {
                return true;
            }
        }
        recst[src] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }
            adj.add(list);
        }
        boolean[] vis = new boolean[n];
        boolean[] recst = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, recst);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < recst.length; i++) {
            if (!recst[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}





// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int V = graph.length;
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i=0;i<V;i++){
//             List<Integer> part = new ArrayList<>();
//         for(int j=0;j<graph[i].length;j++){
//             part.add(graph[i][j]);
//         }
//         adj.add(part);
//         }


//     //    for(int u = 0; u < V; u++) {
//     //         for(int v : graph[u]) {
//     //             adj.get(u).add(v);
//     //         }
//     //     }

//         int vis[]= new int[V];
//         int pathVis[]= new int[V];
//         int check[]= new int[V];
//         for(int i=0;i<V;i++){
//             if(vis[i]==0)
//             dfs(i,adj,vis,pathVis,check);
//         }
    
//     List<Integer> ans = new ArrayList<>();
//     for(int i=0;i<check.length;i++){
//         if(check[i]==1){
//             ans.add(i);
//         }
//     }


//     //  for(int i=0;i<pathVis.length;i++){
//     //     if(pathVis[i]==0){
//     //         ans.add(i);
//     //     }
//     // }
//     return ans;
//     }
//     static boolean dfs(int ind,List<List<Integer>> adj,int vis[],int path[],int check[]){

//            if (path[ind] == 1) {
//             return true; // Cycle detected
//         }
//         if (vis[ind] == 1) {
//             return false; // Already processed
//         }
//         check[ind] =0;
//         vis[ind]=1;
//         path[ind]=1;
//         for(int i : adj.get(ind) ){
//             if(vis[i]==0){
//                 if(dfs(i,adj,vis,path,check))
//                 return true;
//                 // else if(path[i]==1)
//                 // return true;

//             }

//         }
//         check[ind]=1;
//         path[ind]=0;
//         return false;

//     }
// }