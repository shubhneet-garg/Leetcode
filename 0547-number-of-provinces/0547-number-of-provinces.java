class Solution {
    int n;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                provinces++;
                Queue<Integer> q = new LinkedList<>();

                q.add(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int city = q.poll();
                    for(int neighbour = 0; neighbour < n; neighbour++){
                        if(isConnected[city][neighbour] == 1 && !visited[neighbour]){
                            visited[neighbour] = true;
                            q.add(neighbour);
                        }
                    }
                }
            }
        }
        return provinces;
    }
}