import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    dfs(nums,new ArrayList<>(),res, used);
    return res;
}

    public void dfs(int[] nums,List<Integer> list, List<List<Integer>> res,boolean[] used){
        // return
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            int n = nums[i];
            if (!used[i]){
                list.add(n);
                used[i] = true;
                dfs(nums, list,res, used);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}
