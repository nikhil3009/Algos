class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }

        int n = s.length();
        int first = 0;
        int last = n-1;

        while(first<=last){
            char char1 = s.charAt(first);
            char char2 = s.charAt(last);
            if(!Character.isLetterOrDigit(char1)){
                first++;
                continue;
            }
            if(!Character.isLetterOrDigit(char2)){
                last--;
                continue;
            }
            if(Character.toLowerCase(char1)!=Character.toLowerCase(char2)){
                return false;
            }
            first++;
            last--;
        }
        return true;

    }
}