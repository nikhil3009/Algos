lass Node{
        int first;
        int second;
        int third;

public Node(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
        }
        }
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m];
        int ans[][] = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new Node(i,j,0));
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int dx[] = {0,0,1,-1};
        int dy[] = {-1,1,0,0};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            ans[row][col] = steps;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = row+dx[i];
                int ncol = col+dy[i];
                if(nrow>=0 && ncol>=0 && nrow<mat.length && ncol<mat[0].length && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow,ncol,steps+1));
                }
            }
        }
        return ans;
    }
}