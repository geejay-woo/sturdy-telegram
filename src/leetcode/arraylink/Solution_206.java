package leetcode.arraylink;

public class Solution_206 {

    /**
     * 常规解法：指针操作
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre = null, cur = head;
        while(cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur; cur = next;
        }
        return pre;
    }

    /**
     * 使用递归实现
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList2(next);
        next.next = head;
        return newHead;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
