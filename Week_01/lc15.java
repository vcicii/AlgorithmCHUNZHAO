import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList();
        if (nums == null || nums.length<3)
            return list;
        int res;
        Arrays.sort(nums);
        for (int k = 0; k<nums.length - 2;k++){
            if (nums[k]>0)
                break;
            if (k>0&&nums[k] == nums[k-1])
                continue;
            int i = k+1, j = nums.length-1;
            while (i<j){
                res = nums[i]+nums[j]+nums[k];
                if(res == 0){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(i<j && nums[i] == nums[i+1])
                        i++;
                    while(i<j && nums[j] == nums[j-1])
                        j--;
                    i++;
                    j--;
                }else if (res < 0){
                    i++;
                }else if (res > 0){
                    j--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{-1,-1,0,1,2,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}