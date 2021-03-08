public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < (s.length >> 1); ++i){
            char last = s[s.length- 1 - i];
            s[s.length- 1 - i] = s[i];
            s[i] = last;
        }
    }
}
