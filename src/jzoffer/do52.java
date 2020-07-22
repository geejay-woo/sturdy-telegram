package jzoffer;

import entity.ListNode;

public class do52 {
    /**
     * 三种方法解
     * 1，用两个栈：每个链表push进栈；两个栈同时开始pop，第一个不相等的节点的下一个节点，就是第一个公共节点
     * 2，同步两个链表的长度，再开始遍历：第一次遍历记录两个链表的长度差；第二次遍历让长的链表先走长度差步；第一个相等的节点就是公共节点
     * 3，和判断链表中存在环的思路一样，找到递推式，遍历就行
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }
}
