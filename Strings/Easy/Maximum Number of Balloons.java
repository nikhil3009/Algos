class Solution {
    public int maxNumberOfBalloons(String text) {
        char textarr[] = text.toCharArray();
        char baloon[] = "balloon".toCharArray();

        HashMap<Character,Integer> tm = new HashMap<>();
        HashMap<Character,Integer> bm = new HashMap<>();

        for(char c : textarr){
            if(tm.containsKey(c)){
                tm.put(c,tm.get(c)+1);
            }
            else{
                tm.put(c,1);
            }
        }
        for(char c : baloon){
            if(bm.containsKey(c)){
                bm.put(c,bm.get(c)+1);
            }
            else{
                bm.put(c,1);
            }
        }
        int res = text.length();
        for(Character ch : bm.keySet()){
            res = Math.min(res,tm.getOrDefault(ch,0)/bm.get(ch));
        }
        return res;

    }
}