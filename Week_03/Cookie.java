import java.util.Arrays;

class Cookie {
    public int findContentChildren(int[] g, int[] s) {
        if ( g.length == 0||s.length == 0 ){
            return 0;
        }
        int i = 0, j = 0, sat = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (;i < g.length && j < s.length;j++){
            if (s[j] >= g[i]){
                i++;
                sat++;
            }
        }
        return sat;
    }
}