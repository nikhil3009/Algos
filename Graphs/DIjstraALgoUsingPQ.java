class Pair{
    int dist;
    int node;
    Pair(int dist, int node){
        this.dist  = dist;
        this.node = node;
    }
}
class Solution
{

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = (int)1e9;
        }
        dist[S] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.dist-y.dist);
        pq.add(new Pair(0,S));

        while(!pq.isEmpty()){
            int dis = pq.peek().dist;
            int node = pq.peek().node;
            for(int i=0;i<adj.get(node).size();i++){
                int nei = adj.get(node).get(i).get(0);
                int d = adj.get(node).get(i).get(1);
                if(d+dis < dist[nei]){
                    dist[nei] = d+dis;
                    pq.add(new Pair(dist[nei],nei));
                }
            }
        }
        for(int j=0;j<V;j++){
            if(dist[j] == 1e9){
                dist[j] = -1;
            }
        }
        return dist;

    }
}

