class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder ans = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '('){
                if(count>0){
                    ans.append(c);
                }
                count++;
            }
            if(c == ')'){
                count--;
                if(count>0){
                    ans.append(c);
                }
            }
        }
        return ans.toString();

    }
}