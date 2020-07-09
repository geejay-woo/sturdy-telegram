package jzoffer;

import entity.ListNode;

public class do25 {
    //递归
    public static ListNode Merge(ListNode<Integer> list1, ListNode<Integer> list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.val<list2.val) {
            list1.next = Merge(list1.next,list2);
            return list1;
        } else {
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }

    //迭代
    public static ListNode Merge2(ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(list1!=null && list2!=null) {
            if(list1.val<list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1!=null)
            cur.next = list1;
        if(list2!=null)
            cur.next = list2;
        return head.next;
    }
}
