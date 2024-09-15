class Solution
{

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int ans[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        int in[] =  new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                in[it]++;
            }
        }

        for(int i=0;i<V;i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        int j = 0;
        while(!q.isEmpty()){
            int nod = q.peek();
            q.remove();
            ans[j++] = nod;

            for(int it:adj.get(nod)){
                in[it]--;
                if(in[it] == 0)
                {
                    q.add(it);
                }
            }

        }
        return ans;


    }
}