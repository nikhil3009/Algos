class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> ans,int vis[]){
        vis[node] = 1;
        for(int it:ans.get(node)){
            if(vis[it] == 0){
                dfs(it,ans,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    ans.get(i).add(j);
                    ans.get(j).add(i);
                }
            }
        }

        int vis[] = new int[n];
        int cnt = 0;

        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i,ans,vis);
            }
        }

        return cnt;

    }
}