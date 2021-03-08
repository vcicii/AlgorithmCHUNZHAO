public class FirstUnique {
    public int firstUniqChar(String s) {
        int[] list = new int[26];
        for (int i = 0; i < s.length(); ++i){
            list[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); ++i){
            if (list[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
