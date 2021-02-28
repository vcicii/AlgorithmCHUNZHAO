public class Srounded{
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0){
            return;
        }
        int n = board[0].length;
        // first&last row
        for (int j = 0; j < n; ++j){
            dfs(m, n, 0, j, board);
            dfs(m, n, m-1, j, board);
        }
        // first&last col
        for (int i = 0; i < m; ++i){
            dfs(m, n, i, 0, board);
            dfs(m, n, i, n-1, board);
        }

        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (board[i][j] == '-'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int m, int n, int i, int j, char[][] board ){
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || board[i][j] == '-'){
            return;
        }
        // 'O'
        board[i][j] = '-';
        dfs(m, n, i-1, j, board);
        dfs(m, n, i+1, j, board);
        dfs(m, n, i, j-1, board);
        dfs(m, n, i, j+1, board);
    }
}