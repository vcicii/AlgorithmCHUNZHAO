public class StringLow {
    public String toLowerCase(String str) {
        String res = "";
        char[] list = str.toCharArray();
        for (char c : list){
            if (c >= 'A' && c <='Z'){
                c -= 'A' - 'a';
            }
            res += c;
        }

        return res;
    }
}
