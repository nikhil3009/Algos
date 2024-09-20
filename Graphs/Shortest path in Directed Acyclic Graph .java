class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    public int[] shortestPath(int N,int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<N;i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }

        for(int j=0;j<M;j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];
            adj.get(u).add(new Pair(v,wt));
        }


        Stack<Integer> st = new Stack<>();
        int vis[] = new int[N];
        for(int l=0;l<N;l++){
            if(vis[l] == 0){
                toposort(l,adj,vis,st);
            }
        }
        int dist[] = new int[N];
        for(int k=0;k<N;k++){
            dist[k] = (int)1e9;
        }
        dist[0] = 0;
        while(!st.isEmpty()){
            int node =st.peek();
            st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                if(dist[node]+wt<dist[v]){
                    dist[v] = dist[node]+wt;
                }
            }

        }
        for(int s=0;s<N;s++){
            if(dist[s] == 1e9){
                dist[s] = -1;
            }
        }
        return dist;

    }
    public void toposort(int node, ArrayList<ArrayList<Pair>> adj,int vis[],Stack<Integer> st){
        vis[node] = 1;

        for(int i=0;i<adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                toposort(v,adj,vis,st);
            }
        }
        st.add(node);
    }
}