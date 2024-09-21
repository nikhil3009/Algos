class Solution {
    public int celebrity(int mat[][]) {
        int top =0;
        int down = mat.length-1;
        while(top<down){
            if(mat[top][down] == 1){
                top = top+1;
            }
            else if(mat[down][top] == 1){
                down = down-1;
            }
            else{
                top++;
                down--;
            }
        }
        if(top<down){
            return -1;
        }

        for(int i=0;i<mat.length-1;i++){
            if(i == top){
                continue;
            }
            if(mat[top][i] == 0 && mat[i][top] == 1){
                continue;
            }
            else{
                return -1;
            }
        }
        return top;
    }
}