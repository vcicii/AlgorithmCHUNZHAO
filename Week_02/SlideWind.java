public class SlideWind {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2-o1);
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for ( int i=0 ; i<nums.length ; i++ ){
            if ( i >= k ){
                queue.remove(nums[i-k]);
            }
            queue.offer(nums[i]);
            if ( queue.size() == k ){
                res[idx++] = queue.peek();
            }
        }
        return res;
    }
}
