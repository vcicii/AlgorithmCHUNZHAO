public class DecodingDP {
    // int ans = 0;
    // 以 dp[i] 开头的前缀子串有多少种解码方法。
    int[] dp;
    public int numDecodings(String s) {
        int len = s.length();
        if ( len == 0 || s.charAt(0)=='0'){
            return 0;
        }
        dp = new int[len+1];
        dp[len] = 1;
        if(s.charAt(len-1)!='0'){
            dp[len-1] = 1;
        }
        buildDp(s, len);
        return dp[0];
    }

    public void buildDp(String s, int len){
        for (int i = len-2; i >= 0; --i){
            char now = s.charAt(i); // 当前位置的char
            char post = s.charAt(i+1); // 前一位置的char
            String comb = now+""+post+"";
            int combint = Integer.parseInt(comb);
            if (s.charAt(i) == '0'){
                dp[i] = 0;
            }else if (combint>0 && combint <=26){
                dp[i] = dp[i+1] + dp[i+2];
            }else{
                dp[i] = dp[i+1];
            }

        }
    }
}