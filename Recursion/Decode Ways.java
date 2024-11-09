class Solution {
    public int helper(String s, int index){
        if(index <= 0 ){
            return 1;
        }
        int res = 0;
        if(s.charAt(index) != '0'){
            res = helper(s,index-1);
        }
        if(s.charAt(index-1) == '1' || (s.charAt(index-1) == '2' && s.charAt(index)>='0' && s.charAt(index)<='6')){
            res += helper(s,index-2);
        }
        return res;
    }

    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        return helper(s,s.length()-1);
    }
}