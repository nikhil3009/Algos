class Node{
    int first;
    int second;
    public Node(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                if(checkCycle(V,adj,i,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCycle(int V,ArrayList<ArrayList<Integer>> adj,int start, boolean vis[] ){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start,-1));
        vis[start] = true;
        while(!q.isEmpty()){
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();
            for(int it:adj.get(node)){
                if(vis[it] == false){
                    q.add(new Node(it,node));
                    vis[it] = true;
                }
                else if(it != par){
                    return true;
                }
            }
        }
        return false;

    }
}