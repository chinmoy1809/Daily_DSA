class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int count = 0;
        Queue<int[]> que = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] != 0) total++;
                if(grid[i][j] == 2) que.offer(new int[] {i,j});
            }
        }
        int mints =0;
        int x[] = {-1,1,0,0};
        int y[] = {0,0,-1,1};
        while(!que.isEmpty()){
            int k = que.size();
            count += k;

            for(int i=0;i<k;i++){
                int arr[] = que.poll();
                int row = arr[0];
                int col = arr[1];
                
                for(int j=0;j<4;j++){
                    int nrow = row + x[j];
                    int ncol = col + y[j];
                    if(nrow < m && ncol < n && ncol >=0 && nrow >= 0){
                        if(grid[nrow][ncol] == 1){
                            grid[nrow][ncol] = 2;
                            que.offer(new int[]{nrow,ncol});
                        }
                    }
                }

            }
            if(!que.isEmpty()) mints ++;
        }
        return total==count ? mints : -1; 
    }
}