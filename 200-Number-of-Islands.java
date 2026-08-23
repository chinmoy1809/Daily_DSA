class Solution {
    public void DFS(char[][] grid,boolean visited[][],int x[],int y[],int sr,int sc){
        visited[sr][sc] = true;

        for(int i=0;i<4;i++){
            int nr = sr + x[i];
            int nc = sc + y[i];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && !visited[nr][nc] && grid[nr][nc] == '1' ){
                DFS(grid,visited,x,y,nr,nc);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        boolean visited[][] = new boolean[m][n];
        int x[] = {0,0,1,-1};
        int y[] = {1,-1,0,0};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    DFS(grid,visited,x,y,i,j);
                }
            }
        }
        return count;
    }
}