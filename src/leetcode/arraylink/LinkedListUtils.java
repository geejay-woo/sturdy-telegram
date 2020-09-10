package leetcode.arraylink;

import org.junit.Test;

public class LinkedListUtils {
    public static ListNode buildLinkedList(int[] nums){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for(int num:nums) {
            ListNode node = new ListNode(num);
            cur.next = node;
            cur = cur.next;
        }
        return head.next;
    }

    public static void printLinkedList(ListNode head ) {
        while(head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    @Test
    public void test(){
        ListNode node = buildLinkedList(new int[]{1, 2, 3, 4, 5});
        printLinkedList(node);


    }
}
