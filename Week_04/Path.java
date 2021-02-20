public class Path {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n+1];
        dp[n-1] = grid[m-1][n-1];
        for (int k = n-2 ; k >= 0; k--){
            dp[k] = grid[m-1][k]+dp[k+1];
        }
        for (int i = m-2; i >=0; --i){
            for (int j = n-1; j >= 0; --j){
                if (j+1 >= n){
                    dp[j] = grid[i][j] + dp[j];
                    continue;
                }
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
