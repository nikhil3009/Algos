class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        for (int i = 0; i < V; i++) {
            vis[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (vis[i] == -1) {
                if (!dfs(graph, vis, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int[] vis, int node, int color) {
        vis[node] = color;
        for (int neighbor : graph[node]) {
            if (vis[neighbor] == -1) {
                if (!dfs(graph, vis, neighbor, 1 - color)) {
                    return false;
                }
            } else if (vis[neighbor] == color) {
                return false;
            }
        }
        return true;
    }
}