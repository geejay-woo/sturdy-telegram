package jzoffer;

import entity.ListNode;

public class do18 {

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if(head==null || tobeDelete ==null)
            return null;
        if(tobeDelete.next!=null){
            //要删除的节点不是尾节点
            tobeDelete.val = tobeDelete.next.val;
            tobeDelete.next = tobeDelete.next.next;
        } else {
            if(head == tobeDelete)
                //只有一个节点
                head = null;
            else {
                ListNode cur = head;
                while(cur.next!=tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }

    //18.2删除链表中重复的节点
    public ListNode deleteDuplication(ListNode phead) {
        if(phead==null || phead.next==null)
            return phead;
        ListNode next = phead.next;
        if(phead.val == next.val) {
            while(next!=null && phead.val==next.val)
                next = next.next;
            return deleteDuplication(next);
        } else {
            phead.next = deleteDuplication(phead.next);
            return phead;
        }
    }

}
