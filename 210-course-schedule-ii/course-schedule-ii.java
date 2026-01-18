class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // O(e+v)since each node   and e comuted once 
        // same sc as  adj
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        adj.add(new ArrayList<>());
        int indegree[] = new int[numCourses];
        for(int pre[] : prerequisites){
            int course = pre[0];
            int preq = pre[1];
            adj.get(preq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
            q.add(i);
        }

        int ans[] = new int[numCourses];
        int index =0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[index++]=node;
            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0)
                q.add(neigh);
            }

        }
        if(index != numCourses)return new int[0];
        return ans;
        
    }
}