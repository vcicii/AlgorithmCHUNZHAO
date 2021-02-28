import java.util.ArrayList;
import java.util.List;

public class NQueen{
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j){
                chess[i][j] = '.';
            }
        }
        setQueen(res, chess, 0);
        return res;
    }

    public void setQueen(List<List<String>> res, char[][] chess, int level){
        if ( level == chess[0].length){
            res.add(construct(chess));
            return;
        }

        for (int col = 0; col < chess[0].length; ++col){
            if (valid(chess, level, col)){
                chess[level][col] = 'Q';
                setQueen(res, chess, level+1);
                chess[level][col] = '.';
            }
        }
    }

    public boolean valid(char[][] chess, int row, int col){
        for (int r = 0; r <= row; ++r){
            if (chess[r][col] == 'Q'){
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }
}