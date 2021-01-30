public class TopK {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 默认是小根堆，实现大根堆需要重写一下比较器
        Queue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2-o1);
        int[] res = new int[k];
        if (k == 0)
            return res;
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k){
                queue.add(arr[i]);
            }else if (arr[i] < queue.peek()){
                // 达到堆的容积后，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
                // 反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int i = 0;
        while(!queue.isEmpty()){
            res[i] = queue.poll();
            i ++;
        }
        return res;
    }
}
