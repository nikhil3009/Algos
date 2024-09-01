class Solution {

    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int j=0;j<m;j++){
            adj.get(edges[j][0]).add(edges[j][1]);
            adj.get(edges[j][1]).add(edges[j][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int dist[] = new int[n];
        for(int k =0;k<n;k++){
            dist[k] = (int)1e9;
        }
        dist[src] = 0;
        q.add(src);
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int it:adj.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it] = dist[node]+1;
                    q.add(it);
                }
            }
        }
        for(int l=0;l<n;l++){
            if(dist[l] == 1e9){
                dist[l] = -1;
            }
        }
        return dist;
    }
}