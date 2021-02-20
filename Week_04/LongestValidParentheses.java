public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n == 0){
            return 0;
        }
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; ++i){
            if (s.charAt(i) == ')'){
                if (s.charAt(i-1) == '('){
                    if (i-2 >= 0){
                        dp[i] = 2 + dp[i-2];
                    }else{
                        dp[i] = 2;
                    }
                }else{  // 如果前一个是), 则组成))
                    if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                        if (i - dp[i-1] - 2 >= 0){ // 合并之前的有效括号组
                            dp[i] = dp[i-1] + 2 + dp[i - dp[i-1] - 2];
                        }else{
                            dp[i] = dp[i-1] + 2;
                        }
                    }else{
                        dp[i] = 0;
                    }
                }

                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
