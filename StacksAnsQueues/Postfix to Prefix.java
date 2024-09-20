class Solution {
    static String postToPre(String post_exp) {
        int n = post_exp.length();
        Stack<StringBuilder> st = new Stack<>();
        int i=0;
        while(i<n){
            char c = post_exp.charAt(i);
            if((c >= 'a' && c <= 'z' )|| (c >= 'A' && c <= 'Z' ) || (c >='0' && c <= '9')){
                st.push(new StringBuilder().append(c));
            }
            else{
                StringBuilder t1 = st.pop();
                StringBuilder t2 = st.pop();
                StringBuilder cur = new StringBuilder().append(c).append(t2).append(t1);
                st.push(cur);
            }
            i++;

        }
        return st.peek().toString();
    }
}