class Solution {
    public List<Integer> safe(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        int in[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
            }
        }


        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                in[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new List<>();
        for(int i=0;i<numCourses;i++){
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
        return Collections.sort(ans);
    }
}