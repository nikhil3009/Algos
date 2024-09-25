class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int set = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                set += 1;
            }
            if(c == ')'){
                set -=1;
            }

            if(set == -1){
                set = 0;
                res +=1;
            }
        }
        return res+set;

    }
}