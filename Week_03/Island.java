public class Island {
    public int numIslands(char[][] grid) {
        int isl = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    isl++;
                    _trans(grid, i, j);
                }
            }
        }
        return isl;
    }

    public void _trans(char[][] grid, int i, int j){
        if(grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        if (j - 1 >= 0) {
            _trans(grid, i, j-1);
        }
        if (j + 1 <= grid[0].length - 1) {
            _trans(grid, i, j+1);
        }
        if (i - 1 >= 0) {
            _trans(grid, i-1, j);
        }
        if (i + 1 <= grid.length - 1) {
            _trans(grid, i+1, j);
        }
    }
}
