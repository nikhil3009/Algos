class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int index = 0;
        int sign = 1;
        int res = 0;
        if(n == 0){
            return 0;
        }
        while(index<n && s.charAt(index) == ' ' ){
            index++;
        }
        if(index<n && (s.charAt(index) == '+' || s.charAt(index) == '-' )){
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        while(index<n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index++) -'0';

            if(res > (Integer.MAX_VALUE - digit)/10){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res*10+digit;
        }
        return res*sign;
    }
}