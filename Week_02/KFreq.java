public class KFreq {
    public int[] topKFrequent(int[] nums, int k) {
        int [] topk = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        // 将键和值同时存储在栈中
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(new 			                 Comparator<Map.Entry<Integer, Integer>>() {
            // 重写比较器
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            queue.add(item);
        }
        // 取出堆中前k个键值对
        for (int i = 0; i < k; i++) {
            topk[i] = queue.poll().getKey();
            System.out.println(topk[i]);
        }
        return topk;
    }
}
