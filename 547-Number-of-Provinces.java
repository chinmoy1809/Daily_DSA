class Solution {
    public void trevarsal(int node, boolean visited[],int isConnected[][]){
        visited[node] =true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                trevarsal(i,visited,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                trevarsal(i,visited,isConnected);
            }
        }
        return count;
    }
}