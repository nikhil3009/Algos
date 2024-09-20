class Pair{
    String first;
    int second;
    public Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> st = new HashSet<>();
        int n = wordList.size();
        q.add(new Pair(beginWord,1));
        for(int i=0;i<n;i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord) == true){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                for(char j = 'a';j<='z';j++)
                {
                    char replace[] = word.toCharArray();
                    replace[i] = j;
                    String ne = new String(replace);
                    if(st.contains(ne)){
                        q.add(new Pair(ne,steps+1));
                        st.remove(ne);
                    }
                }

            }
        }

        return 0;
    }
}