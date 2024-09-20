class Solution {
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    public static String infixToPostfix(String exp) {
        String ans = new String("");
        Stack<Character> st = new Stack<>();
        int n = exp.length();
        int i=0;
        while( i < n){
            char c = exp.charAt(i);

            if((c >= 'a' && c <= 'z' )|| (c >= 'A' && c <= 'Z' ) || (c >='0' && c <= '9')){
                ans += c;
            }
            else if(c == '('){
                st.push(c);
            }
            else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans += st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && Prec(c) <= Prec(st.peek())){
                    ans +=st.pop();
                }
                st.push(c);
            }
            i++;
        }
        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
    static String preToInfix(String pre_exp) {
        StringBuilder reversedExp = new StringBuilder(pre_exp);
        reversedExp.reverse();
        for (int i = 0; i < reversedExp.length(); i++) {
            char c = reversedExp.charAt(i);
            if (c == '(') {
                reversedExp.setCharAt(i, ')');
            } else if (c == ')') {
                reversedExp.setCharAt(i, '(');
            }
        }
        String postfix = infixToPostfix(reversedExp.toString());

        StringBuilder prefix = new StringBuilder(postfix);
        prefix.reverse();

        return prefix.toString();
    }
}
