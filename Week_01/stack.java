import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class stack {
    public boolean isValid(String s) {
        Stack<Character> nums = new Stack<>();
        Map<Character,Character> dic = new HashMap<>();
        dic.put('{','}');
        dic.put('[',']');
        dic.put('(',')');
        for (char c : s.toCharArray()) {
            if (dic.containsKey(c)){
                nums.push(c);
            }
            else{
                if(nums.isEmpty()||dic.get(nums.peek())!=c){
                    return false;
                }
                nums.pop();
            }
        }

        return nums.isEmpty();
    }

    public static void main(String[] args) {
        new stack().isValid("([]{})");
    }
}
