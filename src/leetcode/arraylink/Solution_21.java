package leetcode.arraylink;

import org.junit.Test;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    @Test
    public void test(){
        ListNode listNode = mergeTwoLists(LinkedListUtils.buildLinkedList(new int[]{1, 2, 4}),
                LinkedListUtils.buildLinkedList(new int[]{1, 3, 4})
        );
        LinkedListUtils.printLinkedList(listNode);
    }
}
