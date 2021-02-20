## 分值、回溯

### 分治代码模板

```java
private static int divide_conquer(Problem problem, ) {
    // recursion terminator 
    if (problem == NULL) {    
        int res = process_last_result();    
        return res;       
    }  
   // conquer subproblems 
    subProblems = split_problem(problem);
    res0 = divide_conquer(subProblems[0]);
    res1 = divide_conquer(subProblems[1]);
    
    // process and generate the final result 
    result = process_result(res0, res1);
    
    // revert the current level status 恢复当前层状态
    return result;
}
```

### [Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)

#### 分治法 Log(n)

```java
class Solution {
    public double myPow(double x, int n) {
        // 负指数幂处理
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return cp(x, n);
    }

    public double cp(double x, int n) {
        // 终止条件
        if (n == 0) {
            return 1.0;
        }
        // sub-problem
        double half = cp(x, n / 2); // 四舍五入
        // merge
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
```

## DFS & BFS

### DFS模板

```java
        public List<List<Integer>> levelOrder(TreeNode root) {        
            List<List<Integer>> allResults = new ArrayList<>();  
            boolean[] used = new boolean[len];
            if(root==null{
                return allResults;        
            }        
            travel(root,0,allResults);        
            return allResults;    
        }    

       private void travel(TreeNode root,int level,List<List<Integer>> results){      
           // 终止条件
           if(results.size()==level){            
               results.add(new ArrayList<>());        
           }        
           // 当前层操作
           results.get(level).add(root.val);
           // 子问题
           if(root.left!=null){            
               travel(root.left,level+1,results);        
           }        
           if(root.right!=null){            
               travel(root.right,level+1,results);        
           }
           // 复原操作
       }
```

### BFS模板

```java
public class TreeNode {    int val;    TreeNode left;    TreeNode right;    TreeNode(int x) {        val = x;    }}public List<List<Integer>> levelOrder(TreeNode root) {    List<List<Integer>> allResults = new ArrayList<>();    if (root == null) {        return allResults;    }    Queue<TreeNode> nodes = new LinkedList<>();    nodes.add(root);    while (!nodes.isEmpty()) {        int size = nodes.size();        List<Integer> results = new ArrayList<>();        for (int i = 0; i < size; i++) {            TreeNode node = nodes.poll();            results.add(node.val);            if (node.left != null) {                nodes.add(node.left);            }            if (node.right != null) {                nodes.add(node.right);            }        }        allResults.add(results);    }    return allResults;}
```



### [电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

#### DFS回溯

```java
class Solution {
    char[][] pad = new char[][]{
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        select(ans,digits,"",0);
        System.out.println(ans);
        return ans;
    }

    private void select(List<String> ans, String digits,String s, int level) {
        // 终止条件
        if (level == digits.length()){
            ans.add(s);
            return;
        }
        //  level 0: for char in [a,b,c]      <--------------------------
        //  s += 'a' (a) 进入到level 1                                   |
        //  level 1: for char in [d,e,f]      <---------------------    |
        //  s += 'd' (ad) 进入到level 2 => return level 1;          |    |
        //  取subseq, [0, level 1)    s = 'a'  ---------------------    |  
        //  取subseq, [0, level 0)    s = ''   --------------------------
        for (char c : pad[digits.charAt(level) - '0']) {
            s += c;
            select(ans,digits,s,level+1);  // 进入到下一层
            s = (String) s.subSequence(0,level); // 消除下一层的影响
        }
    }
}
```

### [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)

#### DFS

```java
public int numIslands(char[][] grid) {
    int isl = 0;
    // 遍历二维数组中的每一个点，如果是1，isl++ , 然后进入dfs，将相邻的陆地(1),变为海洋(0)
    for (int i = 0; i < grid.length; i++){
        for (int j = 0; j < grid[0].length; j++){
            if (grid[i][j] == '1'){
                isl++;
                _trans(grid, i, j);
            }
        }
    }
    return isl;
}

public void _trans(char[][] grid, int i, int j){
    // dfs终止条件: 当前位置是海洋
    if(grid[i][j] == '0')
        return;
    // 陆地 -> 海洋
    grid[i][j] = '0';
    // 搜索四个方位(不能超过四个边界)
    if (j - 1 >= 0)
        _trans(grid, i, j-1);
    if (j + 1 <= grid[0].length - 1)
        _trans(grid, i, j+1);
    if (i - 1 >= 0)
        _trans(grid, i-1, j);
    if (i + 1 <= grid.length - 1)
        _trans(grid, i+1, j);
}
```

## 贪心算法

要求每一步都是当前情况下的最优解

### [跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

```java
// 从前往后跳
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
```

```java
// 从后往前跳
public boolean canJump(int[] nums) {
    if (nums.length < 1){
        return false;
    }
    int start = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--){
        if (nums[i]+i >= start){
            start = i;
        }
    }


    return start == 0;
}
```

## 二分查找

### [搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

```java
// 模板
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2 ; // 找到中间值 (防止超过最大值)
            if (nums[mid] == target){
                return mid;
            }else if (nums[left] <= nums[mid]){ // 左半 单调递增
                if( target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{ 
                    left = mid + 1;
                }
            }else{
                if( target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                } 
            }
        }
        return -1;
    }
}
```

### [搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)

```java
class Solution {
    // 从右上角 向 左下角查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if (matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                System.out.println(matrix[row][col]);
                col--;
            }else{
                System.out.println(matrix[row][col]);
                row++;
            }
        }
        return false;
    }
}
```

### [x 的平方根](https://leetcode-cn.com/problems/sqrtx/)

```java
public int mySqrt(int x) {
    long root;
    long min = 0, max = x;
    while(min <= max){
        root = min + (max - min)/2;
        if (root*root > x){
            max = root - 1;
        }else if (root*root < x){
            min = root + 1;
        }else{
            return (int)root;
        }
    }
    return (int)max;
}
```

