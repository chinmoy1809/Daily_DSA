class Solution {
    public void dfs(int[][] image, int sr, int sc, int og, int newC){
        int x[] = {-1,1,0,0};
        int y[] = {0,0,-1,1};
        image[sr][sc] = newC;

        for(int i=0;i<4;i++){
            int nx = sr + x[i];
            int ny = sc + y[i];
            if(nx >= 0 && ny >= 0 && nx < image.length && ny < image[0].length && image[nx][ny] != newC && image[nx][ny] == og){
                dfs(image,nx,ny,og,newC);
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingColor = image[sr][sc];
        dfs(image,sr,sc,startingColor,color);
        return image;
    }
}