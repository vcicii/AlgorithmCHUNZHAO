import java.util.ArrayList;
import java.util.List;

public class Subset {
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        this.nums = nums;
        _process(res, 0, new ArrayList<>());
        return res;
    }

    public void _process( List<List<Integer>> list, int level, List<Integer> temp){
        if (level >= nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        _process(list, level+1,temp);
        temp.add(nums[level]);
        _process(list, level+1,temp);
        temp.remove(temp.size() - 1);
    }
}
