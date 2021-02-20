public class Palindromic {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n]; // dp[i][j] 代表从i到j是回文串
        int count = 0;
        for (int i = 0; i < n; ++i){
            for (int j = 0; j <= i; ++j){
                if (i == j && s.charAt(i) == s.charAt(j)){
                    dp[j][i] = 1;
                    count++;
                }else if (i - j == 1 && s.charAt(i) == s.charAt(j)){
                    dp[j][i] = 1;
                    count++;
                }else if (i - j > 1 && s.charAt(i) == s.charAt(j) && dp[j+1][i-1] == 1){
                    dp[j][i] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}
