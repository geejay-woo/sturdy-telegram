package jzoffer;

import entity.ListNode;
import util.JUtils;

public class do24 {
    //反转链表

    //最常规解法：涉及大量指针操作
    public static ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode h = head, m = h.next, l = null;
        //记得把指针置为null，不然链表会出现环
        head.next = null;
        while(m!=null) {
            l = m.next;
            m.next = h;
            h = m;
            m = l;
        }
        return h;
    }



    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = ReverseList(head);
        JUtils.showListNode(listNode);
    }
}
