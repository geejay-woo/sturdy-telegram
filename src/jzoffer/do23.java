package jzoffer;

import entity.ListNode;

public class do23 {
    //链表中环的入口节点
    //快慢指针
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null || pHead.next==null)
            return null;
        ListNode slow = pHead,fast = pHead;
        do{
            fast = fast.next.next;
            slow = slow.next;
        }while(slow!=fast);
        fast = pHead;
        while(slow!=fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
