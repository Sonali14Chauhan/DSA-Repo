class Solution {
    boolean res = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for(int i=0; i<n; i++){
            if(color[i] == -1){
              dfs(graph, i, 0, color);
            }
        }
        return res;
    }

    void dfs(int[][] graph, int node, int c, int[] color){
        color[node] = c;
        for(int j=0; j<graph[node].length; j++){
            int n = graph[node][j];
            if(color[n] != -1 && color[n] == c) res = false;

            if(color[n] == -1){
                dfs(graph, n, 1-c, color);
            }
        }
        return;
    }
}