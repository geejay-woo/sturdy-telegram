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

    //递归
    public static ListNode ReverseList1(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode next = head.next;
        ListNode newHead = ReverseList1(next);
        next.next = head;
        return newHead;
    }

    //使用头插法
    public static ListNode ReverseList2(ListNode head) {
        //头节点
        ListNode newList = new ListNode(-1);
        while(head!=null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }


    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode listNode = ReverseList2(head);
        JUtils.showListNode(listNode);
    }
}
