class Solution {
    public boolean isIsomorphic(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        if(ls!=lt){
            return false;
        }

        HashMap<Character,Character> hs = new HashMap<>();
        HashMap<Character,Character> ht = new HashMap<>();

        for(int i=0;i<ls;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if((hs.containsKey(c1) && hs.get(c1) != c2 ) || (ht.containsKey(c2) && ht.get(c2) != c1 )){
                return false;
            }
            hs.put(c1,c2);
            ht.put(c2,c1);
        }

        return true;
    }
}