### [leetcode 21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

#### 递归

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
		
            return l1;
        }
        if ( l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
```

#### 循环

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
```

### leetcode [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

#### 从后向前排序，不需要新的空间

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m-- + n-- - 1;
        while(m >= 0 && n >= 0){
            nums[k--] = nums1[m] <= nums2[n] ? nums2[n--] : nums1[m--];
        }
    
    	//n >= 0 说明仍有在nums2中的元素未插入到nums1中，因为每次插入之后都会--，理想的状态应该是-1 
        while(n >= 0){ 
            nums1[k--] = nums2[n--];
        }
    }
```

