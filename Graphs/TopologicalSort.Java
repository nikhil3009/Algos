class Solution
{
    static void dfs(int V, ArrayList<ArrayList<Integer>> adj, int vis[],Stack<Integer> st,int node){
        vis[node] = 1;
        for(int it:adj.get(node)){
            if(vis[it] == 0){
                dfs(V,adj,vis,st,it);
            }
        }
        st.push(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                dfs(V,adj,vis,st,i);
            }
        }
        int ans[] = new int[V];
        for(int i=0;i<V;i++){
            ans[i] = st.peek();
            st.pop();
        }
        return ans;
    }
}