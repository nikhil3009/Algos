class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else{
                    char cur = st.pop();
                    if(cur == '(' && c == ')' || cur == '{' && c == '}' || cur == '[' && c == ']'){
                        continue;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();

    }
}