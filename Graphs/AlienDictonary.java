class Solution {
    public List<Integer> toposort(int k, List<List<Integer>> adj){
        int in[] = new int[k];
        for(int i=0;i<k;i++){
            for(int j:adj.get(i)){
                in[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            if(in[i] == 0){
                q.add(i);
                ans.add(i);

            }
        }
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int it:adj.get(node)){
                in[it]--;
                if(in[it] == 0){
                    q.add(it);
                    ans.add(it);
                }
            }
        }
        return ans;
    }
    public String findOrder(String[] dict, int n, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int ii=0;ii<len;ii++){
                if(s1.charAt(ii) != s2.charAt(ii)){
                    adj.get(s1.charAt(ii)-'a').add(s2.charAt(ii)-'a');
                    break;
                }
            }
        }

        List<Integer> topo = toposort(k,adj);
        String ans = "";
        for(int it:topo){
            ans = ans + (char)(it + (int)('a'));
        }
        return ans;
    }
}