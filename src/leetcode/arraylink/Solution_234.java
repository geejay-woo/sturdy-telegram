package leetcode.arraylink;

import org.junit.Test;

/**
 * 回文链表
 */
public class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode fast = head, slow = head;
        while(fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        cut(head,slow);
        slow = reverse(slow);
        boolean isPal = true;
        while(head!=null){
            if(head.val!=slow.val) {
                isPal = false;
                break;
            }
            head = head.next;
            slow = slow.next;
        }
        return isPal;
    }

    public ListNode reverse(ListNode node) {
        ListNode head = new ListNode(-1);
        while(node!=null ) {
            ListNode next = node.next;
            node.next = head.next;
            head.next = node;
            node = next;
        }
        return head.next;
    }

    private void cut(ListNode head, ListNode cutPoint) {
        while(head.next!=cutPoint) {
            head = head.next;
        }
        head.next = null;
    }

    @Test
    public void test(){
        boolean palindrome = isPalindrome(LinkedListUtils.buildLinkedList(new int[]{1, 2}));
        System.out.println(palindrome);
    }
}
