public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length < 1){
            return false;
        }
        int reach = 0;
        for (int i = 0; i < nums.length - 1 ; i++){
            if (i <= reach&&nums[i]+i >= reach){
                reach = nums[i]+i;
                System.out.println(reach);
            }
        }
        return reach >= nums.length - 1;
    }
}
