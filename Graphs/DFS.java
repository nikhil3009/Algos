class Solution {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[V+1];
        vis[0] = true;
        dfs(0,vis,ans,adj);
        return ans;
    }
    public void dfs(int node,boolean vis[],ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        ans.add(node);

        for(Integer it:adj.get(node)){
            if(vis[it] == false){
                dfs(it,vis,ans,adj);
            }
        }
    }
}