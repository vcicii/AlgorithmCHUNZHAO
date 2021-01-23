public class lc26 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;

        int idx = 1;
        int tar = nums[0];
        for (int i = 0; i < nums.length ;i++){
            if ( nums[i] == tar ){
                continue;
            }else{
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                tar = nums[idx];
                idx++;
            }
        }
        System.out.println(idx);
        return idx;
    }

    public static void main(String[] args) {
        int[]nums = new int[]{1,2,2,2,4,5,6};
        new lc26().removeDuplicates(new int[]{1,2,2,2,4,5,6});
    }
}
