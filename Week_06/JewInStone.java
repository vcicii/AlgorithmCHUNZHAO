public class JewInStone {
    public int numJewelsInStones(String jewels, String stones) {
        int num = 0;
        for (char j: jewels.toCharArray()){
            for (char s: stones.toCharArray()){
                if (j == s){
                    num++;
                }
            }
        }
        return num;
    }
}
