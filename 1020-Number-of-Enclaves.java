class Solution {
    public void DFS(int grid[][],int x[],int y[],int sr,int sc){
        int m = grid.length;
        int n = grid[0].length;
        grid[sr][sc] = 0;

        for(int i=0;i<4;i++){
            int nr = sr + x[i];
            int nc = sc + y[i];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                DFS(grid,x,y,nr,nc);
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int x[] = {0,0,1,-1};
        int y[] = {1,-1,0,0};
        for(int i=0;i<m;i++){
            if(grid[i][0]==1) DFS(grid,x,y,i,0);
            if(grid[i][n-1]==1) DFS(grid,x,y,i,n-1);
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==1) DFS(grid,x,y,0,i);
            if(grid[m-1][i]==1) DFS(grid,x,y,m-1,i);
        }
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
}