class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        List<Character>[] temp = new ArrayList[s.length()+1];
        for(char key:map.keySet()){
            int frequency = map.get(key);
            if(temp[frequency] == null){
                temp[frequency] = new ArrayList<>();
            }
            temp[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int pos =temp.length-1;pos>=0;pos--){
            if(temp[pos]!=null){
                for(char c : temp[pos]){
                    for(int i=0;i<pos;i++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();

    }
}