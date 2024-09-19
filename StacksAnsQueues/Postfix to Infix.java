class Solution {
    static String postToInfix(String exp) {
        Stack<StringBuilder> st = new Stack<>();
        int i =0;
        while(i<exp.length()){
            char c = exp.charAt(i);
            if((c >= 'a' && c <= 'z' )|| (c >= 'A' && c <= 'Z' ) || (c >='0' && c <= '9')){
                st.push(new StringBuilder().append(c));
            }
            else{
                StringBuilder t1 = st.pop();
                StringBuilder t2 = st.pop();
                StringBuilder cur = new StringBuilder().append("(").append(t2).append(c).append(t1).append(")");
                st.push(cur);
            }
            i++;
        }
        return st.peek().toString();
    }
}