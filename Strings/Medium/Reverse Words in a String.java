class Solution {
    public String reverseWords(String s) {
        s = s.trim() + " ";
        String ans = "";
        Stack<String> st = new Stack<>();
        String temp = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                if(!temp.isEmpty()){
                    st.push(temp);
                    temp = "";
                }
            }
            else{
                temp += s.charAt(i);
            }
        }

        while(!st.isEmpty()){
            if(st.size() == 1){
                ans += st.peek();
            }
            else{
                ans += st.peek() +" ";
            }
            st.pop();
        }

        return ans;
    }
}