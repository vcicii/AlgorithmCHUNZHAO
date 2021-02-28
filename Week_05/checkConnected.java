import java.util.HashMap;
import java.util.Map;

class checkConnected {
    class UnionFind {
        // 记录父节点
        private Map<Integer,Integer> father;
        // 记录集合的数量
        private int numOfSets = 0;

        public UnionFind() {
            // key:子节点
            // val:父节点
            father = new HashMap<Integer,Integer>();
            numOfSets = 0;
        }

        public void add(int x) {
            if (!father.containsKey(x)) {
                father.put(x, null);
                numOfSets++;
            }
        }

        public void merge(int x, int y) {
            // 找到 x，y两个节点的root
            // find(x) 如果x是root直接返回x
            int rootX = find(x);
            int rootY = find(y);

            // 如果连个节点不在一个set中就让 y的root 是 x的root 的父节点
            if (rootX != rootY){
                father.put(rootX,rootY);
                // 总set数减一，因为融合了一个
                numOfSets--;
            }
        }

        public int find(int x) {
            int root = x;

            // 找到根节点
            while(father.get(root) != null){
                root = father.get(root);
            }

            // 压缩路径 (把甘蔗变成香蕉)
            // 如果x不是根节点
            while(x != root){
                // 获得x的父节点
                int original_father = father.get(x);
                // x直接连到root上
                father.put(x,root);
                // 尾节点移到父节点
                x = original_father;
            }

            return root;
        }

        public boolean isConnected(int x, int y) {
            // 两节点是否有共同的父节点
            return find(x) == find(y);
        }

        public int getNumOfSets() {
            return numOfSets;
        }

    }



    public int findCircleNum(int[][] isConnected) {
        // 建立并查集
        UnionFind uf = new UnionFind();
        // 遍历每个节点
        for(int i = 0;i < isConnected.length;i++){
            // 向并查集中添加节点
            uf.add(i);
            // 遍历每个节点的链接情况（只用看一半）
            for(int j = 0;j < i;j++){
                // 如果两个节点有边，merge两个节点
                if(isConnected[i][j] == 1){
                    uf.merge(i,j);
                }
            }
        }
        // 返回并查集中有几个set
        return uf.getNumOfSets();
    }
}