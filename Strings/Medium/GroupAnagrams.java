class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> ans = new HashMap<>();
        for(String s : strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String cur = new String(temp);
            if(!ans.containsKey(cur))
            {
                ans.put(cur,new ArrayList<>());
            }
            ans.get(cur).add(s);

        }

        return new ArrayList<>(ans.values());
    }
}