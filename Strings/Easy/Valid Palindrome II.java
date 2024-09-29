class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int first = 0;
        int last = n-1;
        while(first<=last){
            if(s.charAt(first) == s.charAt(last)){
                first++;
                last--;
            }
            else{
                return validate(s,first+1,last) || validate(s,first,last-1);
            }
        }
        return true;
    }

    public boolean validate(String s, int i, int j){
        while(i<=j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}