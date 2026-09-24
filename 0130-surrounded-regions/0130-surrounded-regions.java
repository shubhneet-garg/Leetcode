class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board);
            }
            if(board[i][m-1] == 'O'){
                dfs(i, m-1, board);
            }
        }

        for(int j=0;j<m;j++){
            if(board[0][j] == 'O'){
                dfs(0, j, board);
            }
            if(board[n-1][j] == 'O'){
                dfs(n-1, j, board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board){
        int n = board.length;
        int m = board[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m || board[row][col] != 'O'){
            return;
        }

        board[row][col] = '#';

        dfs(row-1, col, board);
        dfs(row+1, col, board);
        dfs(row, col-1, board);
        dfs(row, col+1, board);
    }
}