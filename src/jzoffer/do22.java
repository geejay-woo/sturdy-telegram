package jzoffer;

import entity.ListNode;

public class do22 {
    //倒数第k个节点，
    //需要考虑程序的鲁棒性：要是k超过了链表的长度，怎么做？
    public static ListNode FindKthToTail(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode p1 = head;
        while(p1!=null && k-->0)
            p1 = p1.next;
        if(k>0)
            return null;
        ListNode p2 = head;
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(FindKthToTail(head,1).val);
    }
}
