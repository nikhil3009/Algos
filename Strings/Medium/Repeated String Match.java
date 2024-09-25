class Solution {
    public int repeatedStringMatch(String a, String b) {
        int len = b.length()/a.length();
        int count = 0;
        String s = "";
        for(int i=0;i<len+2;i++){
            if(!s.contains(b)){
                s += a;
                count++;
            }
            if(s.contains(b)){
                return count;
            }
        }
        return -1;

    }
}