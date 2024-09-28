class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> h = new HashSet<>();
        h.add('a');
        h.add('e');
        h.add('i');
        h.add('o');
        h.add('u');

        int i=0;
        int res = 0;
        int count =0;

        for(int j=0;j<s.length();j++){
            if(h.contains(s.charAt(j))){
                count = count+1;
            }
            if(j-i+1>k){
                if(h.contains(s.charAt(i))){
                    count = count-1;
                }
                i+=1;
            }
            res = Math.max(res,count);

        }
        return res;
    }
}