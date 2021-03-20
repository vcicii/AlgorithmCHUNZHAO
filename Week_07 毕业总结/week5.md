# 字典树 Trie

实现：

```java
class Trie {
    private class TrieNode{ // 内部类， 创建字典树节点
        boolean isEnd;  // 是否为结尾
        TrieNode[] next;  // 下一个字母指向
        
		// 节点初始化
        public TrieNode(){
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] w = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < w.length; ++i){  // 遍历字符串的每个char
            if (node.next[w[i]-'a'] == null){  // 如果指向为空， 则新建节点
                node.next[w[i]-'a'] = new TrieNode();
            }
            node = node.next[w[i]-'a']; // 1. 如果节点存在 直接指向下个节点 2. 如果节点不存在， 则在新建节点之后指向下个节点
        }
        node.isEnd = true;  // 将最后一个节点设置成结束节点
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] w = word.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < w.length; ++i){
            if (node.next[w[i]-'a'] != null){  // 如果节点存在 则向下移动
                node = node.next[w[i]-'a'];
            }else{  // 如果节点不存在， 则不存在此单词
                return false;
            }

        }
        return node.isEnd;  // 如果移动到了最后， 发现是一个单词的结尾， 则返回true. 否则只是一个单词的前缀， 返回false(单词还未结束)
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] w = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < w.length; ++i){
            if (node.next[w[i]-'a'] != null){
                node = node.next[w[i]-'a'];
            }else{
                return false;
            }

        }
        return true;  // 如果能遍历到最后一个字符， 一定存在 这个前缀/有可能是完整的word
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
```



# 并查集

实现：

```java
class NFIsland {
    class UnionFind{
        public int count;
        public int[] father;
        public UnionFind(int n, int m){
            this.count = n * m;
            this.father = new int[count];
			// 初始化自己为自己的father
            for (int i = 0; i < count; ++i){
                father[i] = i;
            }
        }

        public int find(int x){
            int root = x;
            // 找到x的root
            while (root != father[root]){
                root = father[root];
            }
			// 压缩路径
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
            // 如果x,y根节点不同
            // 把y设置为x的根节点
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
        // 一共有count个互通的set，其中包括了oce个指向自己的0，所以return count - oce;
        return uf.getCount() - oce;
    }

    public int getIndex(int i, int j, int n){
        return i*n + j;
    }

}


```



# AVL树

平衡二叉搜索树（Self-balancing binary search tree）又被称为AVL树（有别于AVL算法），且具有以下性质：

它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。

平衡二叉树上所有结点的平衡因子只可能是 -1，0 或 1。如果某一结点的平衡因子绝对值大于1则说明此树不是平衡二叉树。**为了方便计算每一结点的平衡因子我们可以为每个节点赋予height这一属性，表示此节点的高度。**

**四种旋转**

1. 左旋

   ```bash
   1节点左旋
   		1							2
   			2          =>         1		   3 
   				3
   ```

   

2. 右旋

   ```bash
   1节点右旋
   		1                          2
   	2                   =>     3        1
   3
   ```

3. 左右旋

   ```bash
   1节点左旋
   2节点右旋
                    2                      2                  3
               1            =>          3           =>     1     2
                    3               1
   ```

4. 右左旋

   ```bash
   3节点右旋
   2节点左旋
   
   			2                  2                         1
   			    3       =>         1          =>     2       3
   			1                         3
   ```

   

# 红黑树

红黑树，Red-Black Tree 「RBT」是一个自平衡(不是绝对的平衡)的二叉查找树(BST)，解决了二叉查找树的线性问题，实现平衡性，树上的每个节点都遵循下面的规则:

- 每个节点都有红色或黑色
- 树的根始终是黑色的 
- 没有两个相邻的红色节点 （红色节点不能有红色父节点或红色子节点，**并没有说不能出现连续的黑色节点**）
- 从节点（包括根）到其任何后代NULL节点的每条路径都具有相同数量的黑色节点   (叶子结点下方挂的两个空节点，并且认为他们是黑色的)

红黑树有两大操作:

- recolor (重新标记黑色或红色)
- rotation (旋转，这是树达到平衡的关键)

# 位运算

### 基本操作：

| 操作 |    运算符    | 结果 |
| :--: | :----------: | ---- |
| 左移 | 0110  <<  1  | 1100 |
| 右移 |  0110  >> 1  | 0011 |
|  或  | 0110 \| 1001 | 1111 |
|  与  | 0011 & 1011  | 0011 |
| 取反 |    ~ 1010    | 0101 |
| 异或 | 0011 ^ 1011  | 10   |

异或（不进位加法）

### 常见公式：

```bash
x ^ 0 = x
x ^ 1s = ~x
x ^ (~x) = 1s
x ^ x = 0
```

### 指定位置的位运算：

```bash
1. 将x最右边的n位清零:
	x & (~0 << n)
2. 获取x的第n位值:
	1 & (x >> n)
3. 获取x的第n位的幂值:
	x & (1 << n)
4. 仅将x的第n位置1:
	x | (1 << n)
5. 仅将x的第n位置0:
	x & (~(1 << n))
6. 将x最高位至第n位清零
	x & ((1 << n) - 1)
```

### 运算要点：

```bash
# 判断积偶：
奇: x & 1 == 1
偶: x & 1 == 0

# 除2：
x = x/2 => x = x >> 1

# 清除最低位的1：
x = x & (x - 1)

# 得到最低位的1的幂值：
x & (-x)


```

