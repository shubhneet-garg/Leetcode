class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j});
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = -1;
                }
            }
        }

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0, 1}};

        while(!q.isEmpty()){
            int[] current = q.poll();

            int row = current[0];
            int col = current[1];

            for(int[] direction : directions){
                int newrow = row + direction[0];
                int newcol = col + direction[1];

                if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && dist[newrow][newcol] == -1){
                    dist[newrow][newcol] = dist[row][col] + 1;
                    q.add(new int[]{newrow, newcol});
                }
            }
        }
        return dist;
    }
}