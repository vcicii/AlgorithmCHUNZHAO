class MosNum {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if (major == nums[i]){ // 如果当前位置元素=major，则让计票++
                count++;
            }else if(--count == 0) {
                // 如果！= major，就抵消一张major的选票。如果count为零，更换major为当前元素,并将计票设置为1
                major = nums[i];
                count = 1;
            }
        }
        return major;
    }
}