class Solution {
    void dfs(int row, int col, int vis[][], int grid[][],int n, int m){
        vis[row][col] =1;
        int dx[] = {0,0,1,-1};
        int dy[] = {-1,1,0,0};
        for(int i=0;i<4;i++){
            int nrow = row+dx[i];
            int ncol = col+dy[i];
            if(nrow>=0&&ncol>=0&&nrow<n&&ncol<m&&vis[nrow][ncol] ==0 && grid[nrow][ncol] ==1){
                dfs(nrow,ncol,vis,grid,n,m);
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int cnt =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    cnt++;
                    dfs(i,j,vis,grid,n,m);
                }
            }
        }
        return cnt;
    }
}