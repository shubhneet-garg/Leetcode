class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++){
            if(grid[i][0] == 1){
                dfs(i, 0, grid);
            }
            if(grid[i][col-1] == 1){
                dfs(i, col-1, grid);
            }
        }
        for(int j=0;j<col;j++){
            if(grid[0][j] == 1){
                dfs(0, j, grid);
            }
            if(grid[row-1][j] == 1){
                dfs(row-1, j, grid);
            }
        }

        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int row, int col, int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return;
        }

        grid[row][col] = 0;

        dfs(row-1, col, grid);
        dfs(row+1, col, grid);
        dfs(row, col-1, grid);
        dfs(row, col+1, grid);
    }
}