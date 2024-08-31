class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O' && vis[i][0] == 0){
                dfs(board,vis,i,0,n,m);
            }
            if(board[i][m-1] == 'O' && vis[i][m-1] == 0){
                dfs(board,vis,i,m-1,n,m);
            }
        }
        for(int j=0;j<m;j++){
            if(board[0][j] == 'O' && vis[0][j] == 0){
                dfs(board,vis,0,j,n,m);
            }
            if(board[n-1][j] == 'O' && vis[n-1][j] == 0){
                dfs(board,vis,n-1,j,n,m);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }

    }
    public void dfs(char[][] board,int vis[][], int row, int col, int n, int m){
        vis[row][col] = 1;
        int dx[] = {0,0,1,-1};
        int dy[] = {-1,1,0,0};
        for(int i=0;i<4;i++){
            int nrow = row+dx[i];
            int ncol = col+dy[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(board,vis,nrow,ncol,n,m);
            }
        }
    }
}