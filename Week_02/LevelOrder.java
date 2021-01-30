public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            // 每次都是使用队列中节点的数量来控制一层的节点出栈
            // 第一次while，队列中 只有一个节点，for i<1 , 代表树的第一层，向队列中offer子节点(计入下次迭代的i)；
            // 第二次while，第一层元素已经出队，剩下的是 前一次for循环中 新offer的节点;
            for(int i = 0; i < len; i++){
                Node node = queue.poll();
                list.add(node.val);
                // queue.addAll(node.children);
                List<Node> n_list = node.children;
                for(Node no : n_list){
                    queue.offer(no);
                }
            }
            res.add(list);
        }
        return res;
    }
}
