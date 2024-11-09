class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String out = "";
        helper(n,n,n,ans,out);
        return ans;
    }
    public void helper(int n, int open, int close,List<String> ans, String out){
        if(open == 0 && close == 0){
            ans.add(out);
            return;
        }
        if(open !=0) {
            String temp = out;
            temp = temp + "(";
            helper(n, open - 1, close, ans, temp);


        }
        if(close>open){
            String temp = out;
            temp = temp+")";
            helper(n,open,close-1,ans,temp);
        }
    }
}