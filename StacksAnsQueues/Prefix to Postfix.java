class Solution {
    static String preToPost(String pre_exp) {
        int n = pre_exp.length();
        Stack<StringBuilder> st = new Stack<>();
        int i=n-1;
        while(i>=0){
            char c = pre_exp.charAt(i);
            if((c >= 'a' && c <= 'z' )|| (c >= 'A' && c <= 'Z' ) || (c >='0' && c <= '9')){
                st.push(new StringBuilder().append(c));
            }
            else{
                StringBuilder t1 = st.pop();
                StringBuilder t2 = st.pop();
                StringBuilder cur = new StringBuilder().append(t1).append(t2).append(c);
                st.push(cur);
            }
            i--;

        }
        return st.peek().toString();
    }
}