public class Decoding {
    int ans = 0;
    public int numDecodings(String s) {
        dfs(s);
        return ans;
    }
    public void dfs(String s){ //62367
        if (s.length() == 0){  // 如果空 结束递归
            ans++;
            return;
        }
        int t = Integer.parseInt(s.substring(s.length()-1));
        if ( t != 0){
            dfs(s.substring(0, s.length()-1));
        }
        // 检查后两位是否在范围内
        if(s.length()>= 2){
            t = Integer.parseInt(s.substring(s.length()-2));
            int v = Integer.parseInt(s.substring(s.length()-2, s.length()-1));
            if ( v != 0 && 0 <= t && t <= 26){
                dfs(s.substring(0, s.length()-2));
            }
        }

        return;
    }
}
