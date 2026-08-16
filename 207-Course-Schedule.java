class Solution {
    public boolean isCyclePresent(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited,boolean path[]){
        visited[node] = true;
        path[node] = true;
        for(int adjNode: adj.get(node)){
            if(!visited[adjNode]){
                if(isCyclePresent(adjNode,adj,visited,path)) return true;
            }else if(path[adjNode]) return true;
        }
        path[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(isCyclePresent(i,adj,visited,path))  return false;
            }
        }
        return true;
    }
}