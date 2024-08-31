class Node{
    int first;
    int second;
    public Node(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j ==0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        vis[i][j] = 1;
                        q.add(new Node(i,j));
                    }
                }
            }
        }
        int dx[] = {0,0,1,-1};
        int dy[] = {-1,1,0,0};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol <m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow,ncol));
                }

            }
        }

        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;

    }
}