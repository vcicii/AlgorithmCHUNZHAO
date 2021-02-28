class NFIsland {
    class UnionFind{
        public int count;
        public int[] father;
        public UnionFind(int n, int m){
            this.count = n * m;
            this.father = new int[count];

            for (int i = 0; i < count; ++i){
                father[i] = i;
            }
        }

        public int find(int x){
            int root = x;
            while (root != father[root]){
                root = father[root];
            }

            while (x != root){
                int origin_father = father[x];
                father[x] = root;
                x = origin_father;
            }
            return root;
        }

        public void merge(int x, int y){
            int fx = find(x);
            int fy = find(y);
            if (fx != fy){
                father[fx] = fy;
                this.count--;
            }
        }

        public int getCount(){
            return this.count;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0){
            return 0;
        }
        int oce = 0;
        UnionFind uf = new UnionFind(m,n);
        int[][] directions = {{1,0},{0,1}};
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j] == '0'){
                    oce++;
                }else{
                    for (int[] direction: directions){
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (x < m && y < n && grid[x][y] == '1'){
                            uf.merge(getIndex(i, j, n), getIndex(x, y, n));
                        }
                    }
                }
            }
        }
        // 一共有count个互通的set，其中包括了oce个应该排除在外的0 所以return count - oce;
        return uf.getCount() - oce;
    }

    public int getIndex(int i, int j, int n){
        return i*n + j;
    }

}

