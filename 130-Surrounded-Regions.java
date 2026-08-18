class Solution {
    public void DFS(char[][] board, int visited[][],int x[],int y[],int sr,int sc){
        int m = board.length;
        int n = board[0].length;
        visited[sr][sc] = 1;

        for(int i=0;i<4;i++){
            int nr = sr + x[i];
            int nc = sc + y[i];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O' && visited[nr][nc] == 0){
                DFS(board,visited,x,y,nr,nc);
            }
        }

    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int visited[][] = new int[m][n];
        int x[] = {0,0,1,-1};
        int y[] = {1,-1,0,0};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && board[i][j] == 'O'){
                    DFS(board, visited,x,y,i,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }

    }
}