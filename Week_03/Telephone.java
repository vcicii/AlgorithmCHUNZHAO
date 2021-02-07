import java.util.ArrayList;
import java.util.List;

public class Telephone {

    char[][] pad = new char[][]{
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        select(ans,digits,"",0);
        System.out.println(ans);
        return ans;
    }

    private void select(List<String> ans, String digits,String s, int level) {
        // terminator
        if (level == digits.length()){
            ans.add(s);
            return;
        }
        for (char c : pad[digits.charAt(level) - '0']) {
            s += c;
            select(ans,digits,s,level+1);
            s = (String) s.subSequence(0,level);
        }
    }
}
