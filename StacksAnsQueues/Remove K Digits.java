class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> st = new LinkedList<>();
        for(int i=0;i<num.length();i++){
            char c = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()-'0'>c-'0'){
                st.pop();
                k--;
            }
            st.push(c);
        }

        while(!st.isEmpty() && st.peekLast() == '0'){
            st.pollLast();
        }

        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pollLast());
        }
        return res.isEmpty() ? "0" : res.toString();

    }
}