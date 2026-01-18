class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // tc O(e+v)as each e and v is processed once
        // sc O(e+v) as adj list 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses ;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[numCourses];
        for(int preq[] : prerequisites){
            int course = preq[0];
            int pre = preq[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses ;i++){
            if(indegree[i]==0)
            q.add(i);
        }
        int count =0;
        while(!q.isEmpty()){
            int node = q.poll();
            count ++;
            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0)
                q.add(neigh);
            }
        }
        return count == numCourses;
        
    }
}