class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ini = image[sr][sc];
        int[][] ans = image;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        dfs(image,ans,sr,sc,color,ini,dx,dy);
        return ans;
    }

    public void dfs(int[][] image,int[][] ans,int sr, int sc, int color,int ini,int dx[],int dy[]){
        ans[sr][sc] = color;
        for(int i=0;i<4;i++){
            int row = dx[i] + sr;
            int col =dy[i] + sc;
            if(row>=0&&row<image.length && col>=0 && col<image[0].length && image[row][col] == ini && ans[row][col] != color){
                dfs(image,ans,row,col,color,ini,dx,dy);
            }
        }
    }
}