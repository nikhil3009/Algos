class Solution {
    public int maxDepth(String s) {
        int par = 0;
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                par++;
            }
            else if(c == ')'){
                par--;
            }
            ans = Math.max(par,ans);
        }
        return ans;

    }
}