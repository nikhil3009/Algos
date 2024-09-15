class Solution {
    class Tuple{
        int dist;
        int row;
        int col;
        Tuple(int dist, int row, int col){
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1){
            return -1;
        }
        Queue<Tuple> q = new LinkedList<>();
        int dist[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 1;
        q.add(new Tuple(1,0,0));
        int dr[] = {-1, -1, -1, 0, 1, 1, 1, 0};
        int dc[] = {-1, 0, 1, 1, 1, 0, -1, -1};
        while(!q.isEmpty()){
            int d = q.peek().dist;
            int r = q.peek().row;
            int c = q.peek().col;
            q.remove();

            if(r == n-1 && c == m-1){
                return d;
            }
            for(int i=0;i<8;i++){
                int nr = r+dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc] == 0 && 1+d<dist[nr][nc]){
                    dist[nr][nc] = 1+d;
                    q.add(new Tuple(1+d,nr,nc));
                }
            }


        }
        return -1;
    }
}
