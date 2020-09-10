package leetcode.arraylink;

import org.junit.Test;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for(int i = 0; i<n; i++) {
            fast = fast.next;
        }
        if(fast==null) return head.next;
        ListNode slow = head;
        while(fast.next!=null) {
            slow=slow.next;
            fast=fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    @Test
    public void test(){
        ListNode input = LinkedListUtils.buildLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = removeNthFromEnd(input, 2);
        LinkedListUtils.printLinkedList(listNode);
    }
}
