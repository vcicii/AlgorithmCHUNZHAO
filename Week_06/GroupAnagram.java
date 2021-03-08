import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] code = str.toCharArray();
            Arrays.sort(code);
            String key = new String(code);
            if (map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> nl = new ArrayList<>();
                nl.add(str);
                map.put(key,nl);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (List<String> value : map.values()) {
            list.add(value);
        }
        return list;
    }
}
