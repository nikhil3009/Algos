class Solution {
    static String preToInfix(String pre_exp) {
        Stack<StringBuilder> st = new Stack<>();
        int i = pre_exp.length()-1;
        while(i>=0){
            char c = pre_exp.charAt(i);
            if((c >= 'a' && c <= 'z' )|| (c >= 'A' && c <= 'Z' ) || (c >='0' && c <= '9')){
                st.push(new StringBuilder().append(c));
            }
            else{
                StringBuilder t1 = st.pop();
                StringBuilder t2 = st.pop();
                StringBuilder cur = new StringBuilder().append("(").append(t1).append(c).append(t2).append(")");
                st.push(cur);
            }
            i--;
        }
        return st.peek().toString();
    }
}