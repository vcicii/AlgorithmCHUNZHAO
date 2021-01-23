import java.util.ArrayList;
import java.util.List;

public class lc42 {
    public int trap(int[] height) {
        int all = 0;
        int[] higher = new int[height.length/2];
        int idx = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0){
                System.out.println("first");
                if(height[i] >= height[i+1]){
                    higher[idx] = i;
                    idx++;
                }
                continue;
            }

            if (i == height.length-1){
                System.out.println("last");
                if(height[i] >= height[i-1]){
                    higher[idx] = i;
                    idx++;
                }
                continue;
            }
            if (height[i]>height[i+1]&&height[i]>height[i-1]){
                higher[idx] = i;
                idx++;
            }
        }
        for (int i : higher) {
            System.out.print(i+" ");
        }
        System.out.println();

        for (int j = 0; j < idx-1;j++){
            int h = Math.min(height[higher[j]],height[higher[j+1]]);
            System.out.println("h"+h);
            System.out.print("k ");
            for (int k = higher[j]; k <= higher[j+1];k++){
                System.out.print(height[k]+" ");
                if (h-height[k]>=0){
                    all += h-height[k];
                }
                System.out.println("all"+all);
            }
            System.out.println();
        }
        return all;
    }

    public static void main(String[] args) {
        System.out.println(new lc42().trap(new int[]{4,2,0,3,2,5}));
    }
}
