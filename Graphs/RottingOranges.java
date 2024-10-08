class Pair{
    int row;
    int col;
    int t;
    Pair(int row,int col,int t){
        this.row = row;
        this.col = col;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        int fresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int tm = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        int cnt =0;
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int t = q.peek().t;
            tm = Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = dx[i] + row;
                int ncol = dy[i] + col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }

        }

        if(fresh!=cnt){
            return -1;
        }

        return tm;

    }

}