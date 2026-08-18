class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int output[][] = new int[m][n];
        int visited[][] = new int[m][n];
        Queue<int[]> que = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    que.offer(new int[] {i,j,0});
                    visited[i][j] = 1;
                }
            }
        }

        int x[] = {1,-1,0,0};
        int y[] = {0,0,1,-1};

        while(!que.isEmpty()){
            int nums[] = que.poll();
            int row = nums[0];
            int col = nums[1];
            int steps = nums[2];

            output[row][col] = steps;
            for(int i=0;i<4;i++){
                int nr = row + x[i];
                int nc = col + y[i];

                if(nr >=0 && nr < m && nc >=0 && nc < n && visited[nr][nc] == 0){
                    visited[nr][nc] = 1; 
                    que.offer(new int[] {nr,nc,steps+1});
                }
            }
        }
        return output;
    }
}