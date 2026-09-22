class Solution {
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                provinces++;
                dfs(i, isConnected, visited);
            }
        }
        return provinces;
    }

    public void dfs(int city, int[][] isConnected, boolean[] visited){
        visited[city] = true;

        for(int neighbour = 0;neighbour<n;neighbour++){
            if(isConnected[city][neighbour] == 1 && !visited[neighbour]){
                dfs(neighbour, isConnected, visited);
            }
        }
    }
}