import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> code = new HashMap<>();
        char[]tar = s.toCharArray();
        char[]jud = t.toCharArray();

        for (char c : tar) {
            if (code.containsKey(c)){
                code.put(c,code.get(c)+1);
            }else {
                code.put(c,1);
            }
        }

        for (char c : jud) {
            if (!code.containsKey(c)){
                return false;
            }else{
                code.put(c,code.get(c)-1);
            }
        }
        Integer add = 0;
        for (Integer value : code.values()) {
            if (value < 0)
                return false;
            add += value;
        }
        return add == 0;
    }
}
