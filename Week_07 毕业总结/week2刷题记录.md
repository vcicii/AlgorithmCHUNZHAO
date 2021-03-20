## 树 

### [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

#### 递归

```java
class Solution {
    List<Integer> it = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null){
            it.add(root.val);
            this.preorderTraversal(root.left);
            this.preorderTraversal(root.right);
        }
        return it;
    }
}
```



#### 利用栈迭代 (颜色标记法)

```java
public static List<Integer> inOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {  //空树直接返回
        return res;
    }
    TreeNode cur = root;
    Stack<Object> stack = new Stack<>();
    stack.push(cur);
    while (!stack.empty()) {
        Object o = stack.pop();
        if (o instanceof TreeNode) {  //如果是节点，说明还没遍历过此节点下的子树
            TreeNode node=(TreeNode) o;
            //因为中序遍历是左节点--根节点--右节点
            //即出栈顺序为左节点--根节点--右节点，入栈顺序相反
            if (node.right != null)
                stack.push(node.right);
            stack.push(node.val); // 只需到改动此行位置便可实现 前 中 后 序遍历
            if (node.left != null)
                stack.push(node.left);
        } 
        else {  // 如果是int 说明已经遍历过了，直接添加到数组中
            res.add((int)o);
        }   	 
    }
    return res;  
}
```

### [N叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/)

#### 递归  

```java
class Solution {
    List<Integer> it = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root != null){
            for(Node node: root.children){
                this.postorder(node);
            }
            it.add(root.val);
        }
        return it;
    }
}
```

#### 利用栈迭代

```java
class Solution {
    List<Integer> it = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {  //空树直接返回
            return res;
        }
        Node cur = root;
        Stack<Object> stack = new Stack<>();
        stack.push(cur);
        while (!stack.empty()) {
            Object o = stack.pop();
            if (o instanceof Node) {  
                Node node=(Node) o;
                stack.push(node.val); 
                Collections.reverse(node.children);  // 注意此处，由于算法需要逆向入栈，才能正向出栈。
                for (Node n : node.children){
                    if (n != null)
                        stack.push(n);
                }
            } 
            else {  
                res.add((int)o);
            }   	 
        }
        return res;  
    }
}
```

### [翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/)

#### 递归

```java
/**
先序遍历：先交货左右子树，再分别递归
**/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode node = root.left; //保存左子树
        root.left = invertTree(root.right);  //左节点等于 右节点的递归值
        root.right = invertTree(node);  // 右节点等于 左节点的递归值
        return root;
    }
}

/**
中序遍历：先递归左子树，再交换左右节点，再递归左子树（因为没被递归过的右子树已经换到左边了）
**/
class Solution {
    public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            invertTree(root.left); // 递归找到左节点
            TreeNode rightNode= root.right; // 保存右节点
            root.right = root.left;
            root.left = rightNode;
            // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
            invertTree(root.left); 
    }
}

/**
后序遍历：先操作两个子节点的，再交换两个节点的位置。
**/
 class Solution {
        public TreeNode invertTree(TreeNode root) {
            // 后序遍历-- 从下向上交换
            if (root == null) return null;
            TreeNode leftNode = invertTree(root.left);
            TreeNode rightNode = invertTree(root.right);
            root.right = leftNode;
            root.left = rightNode;
            return root;
        }
    }

/**
层序遍历
**/
   class Solution {
        public TreeNode invertTree(TreeNode root) {
            // 层次遍历--直接左右交换即可
            if (root == null) return null;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                TreeNode rightTree = node.right;
                node.right = node.left;
                node.left = rightTree;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }
```

### [N 叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/)

#### 队列

实现广度优先搜索

```java
class Solution {
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
```

### [最小的k个数( top k )](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

#### 堆

```java
class Solution {
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
```

#### 快排

```java



```





### [前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

#### 堆

```java
public class TopK {
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
```



### [滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

#### 堆 

```java
//超时啦
class Solution {
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
```

#### 单调栈

```java
public int[] maxSlidingWindow(int[] nums, int k){
        int[] list = new int[nums.length - k + 1];
        if (nums.length == 0){
            return list;
        }e
        Deque<Integer> idx = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果队列非空，比较入队元素 与 队列中最后一个元素的大小
            // 如果 入 大于 队尾， 将队尾元素出队，直到队为空 或 入小于队尾。
            while(!idx.isEmpty()&&nums[i]>=nums[idx.getLast()]){
                idx.pollLast();
            }
            idx.offerLast(i);
            // 如果队列非空，而且窗口已经形成，向list中添加队首元素(max val)
            if (!idx.isEmpty()&&i>=k-1){
                list[i-k+1] = nums[idx.peekFirst()];
            }
            // 如果队首元素超出 窗口范围，将队首出队
            if (!idx.isEmpty()&&idx.peekFirst()<=i-k+1){
                idx.pollFirst();
            }
        }
        return list;
    }
```



### 验证二叉树

#### 节点递归

```java
public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
    if (root == null)
        return true;
    //每个节点如果超过这个范围，直接返回false
    if (root.val >= maxVal || root.val <= minVal)
        return false;
    //这里再分别以左右两个子节点分别判断，
    //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
    //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
    return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
}
```

#### 中序遍历

合法的**BST**中序遍历之后一定是递增的

```java
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // 递归结束条件
        if (root == null)
            return true;
        // 判断左节点是否valid
        if (!isValidBST(root.left))
            return false;
        // 判断跟节点的值 是否 <= 前一节点的值
        if (root.val <= pre)
            return false;
        // 此节点变成了 下一节点的比较对象
        pre = root.val;
        return isValidBST(root.right);
    }
}
```

### [丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)

```java
// 不是很懂这个逻辑
class Solution {
    public int nthUglyNumber(int n) {
        if( n == 0)
            return -1;
        int[] res = new int[n];
        res[0] = 1;
        int i2 =0,i3=0,i5 = 0;
        for (int i = 1; i < n ;i++){
            res[i] = Math.min(Math.min(res[i2]*2,res[i3]*3),res[i5]*5);
            if (res[i] == res[i2]*2) i2++;
            if (res[i] == res[i3]*3) i3++;
            if (res[i] == res[i5]*5) i5++;
        }
        return res[n-1];
    }
}
```





## 图

### 图的高级算法

连通图个数

拓扑排序

最短路径 Dijkstra

最小生成树