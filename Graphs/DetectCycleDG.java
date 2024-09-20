class Solution {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pvis[] = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(i,vis,pvis,adj) == true)
                {
                    return true;
                }
            }
        }
        return false;

    }
    public boolean dfs(int i, int[] vis, int[] pvis,ArrayList<ArrayList<Integer>> adj ){
        vis[i] = 1;
        pvis[i] =1;

        for(int it : adj.get(i)){
            if(vis[it] == 0){
                if(dfs(it,vis,pvis,adj) == true){
                    return true;
                }
            }
            else if(pvis[it] == 1)
            {
                return true;
            }
        }
        pvis[i]=0;
        return false;
    }
}