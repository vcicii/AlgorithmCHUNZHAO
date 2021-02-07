import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        // sort是剪枝的前提
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), used);
        return res;
    }

    public void dfs(int[] nums,List<List<Integer>> res, List<Integer> list, boolean[] used ){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i){
            if (!used[i]){
                // 如果i-1还没用过，说明是刚刚回溯过的，需要剪枝
                // 如果i-1已经用过了， 说明是同一只树上的，不需要剪纸
                if ( i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                    continue;
                }
                int n = nums[i];
                used[i] = true;
                list.add(n);
                System.out.println(list);
                dfs(nums, res,list, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
