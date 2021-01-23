public class lc206 {
    public ListNode reverseList(ListNode head) {
        ListNode pos = null;
        ListNode pre = head;
        while(head!=null&&head.next != null){
            pre = head.next;
            head.next = pos;
            pos = head;
            head = pre;
        }
        head.next = pos;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

