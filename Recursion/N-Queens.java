
// column wise queen insertion
class Solution {
    private List<String> construct(char[][] board){
        List<String> cur = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            cur.add(new String(board[i]));
        }
        return cur;
    }
    private boolean isValid(int row, int col,char[][] board, int n){
        // check column wise
        for(int c =0;c<col;c++){
            if(board[row][c] == 'Q'){
                return false;
            }
        }
        for(int r = row,c = col;r>=0 && c>=0;r--,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        for(int r = row,c = col;r<n && c>=0;r++,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;
    }
    private void helper(int col, int n, char[][] board,List<List<String>> res){
        if(col == n){
            res.add(construct(board));
            return;
        }
        for(int row =0;row<n;row++){
            if(isValid(row,col,board,n)){
                board[row][col] = 'Q';
                helper(col+1,n,board,res);
                board[row][col] = '.';
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        helper(0,n,board,res);
        return res;
    }
}

//row wise queen insertion
class Solution {
    private List<String> construct(char[][] board){
        List<String> res = new LinkedList<>();
        for(int i=0;i<board.length;i++){
            res.add(new String(board[i]));
        }
        return res;
    }
    private boolean isValid(int row, int col, int n,char[][] board){
        for(int r=0;r<n;r++){
            if(board[r][col] == 'Q'){
                return false;
            }
        }
        for(int r = row,c = col;r>=0 && c>=0;r--,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        for(int r = row,c = col;r>=0 && c<n;r--,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private void helper(int row, int n,char[][] board, List<List<String>> ans){
        if(row == n){
            ans.add(construct(board));
            return;
        }
        for(int col=0;col<n;col++){
            if(isValid(row,col,n,board)){
                board[row][col] = 'Q';
                helper(row+1,n,board,ans);
                board[row][col] = '.';
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        helper(0,n,board,ans);
        return ans;
    }
}