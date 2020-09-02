package leetcode.arraylink;

/**
 * 两两交换链表中的节点
 */
public class Solution_24 {
    /**
     * 迭代的方法解决
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        while(head!=null && head.next!=null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }

    /**
     * 递归的方式实现
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        ListNode next = secondNode.next;
        secondNode.next = firstNode;
        firstNode.next = swapPairs2(next);
        return secondNode;
    }


}
