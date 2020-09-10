package leetcode.arraylink;

import org.junit.Test;

/**
 *
 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode node = deleteDuplicates(head.next);
        if(head.val==node.val) head.next = node.next;
        return head;
    }
    @Test
    public void test(){
        ListNode node = deleteDuplicates(LinkedListUtils.buildLinkedList(new int[]{1, 1, 2}));
        LinkedListUtils.printLinkedList(node);
    }
}
