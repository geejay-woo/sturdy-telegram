package leetcode.arraylink;

import org.junit.Test;

/**
 * 本题拓展：如果判断是否存在交点：
 * 把第一个链表的结尾连接到第二个链表的开头
 * 1，看第二个链表是否存在环
 * 2，看两个链表的最后一个节点是否相同
 */
public class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0, countB = 0;
        ListNode cur = headA;
        while(cur!=null) {
            countA++;
            cur = cur.next;
        }
        cur = headB;
        while(cur!=null) {
            countB++;
            cur = cur.next;
        }
        int diff = Math.abs(countA-countB);
        ListNode first = countA>countB?headA:headB;
        ListNode second = first==headA?headB:headA;
        for(int i = 0; i<diff; i++) {
            first = first.next;
        }
        while(first!=second) {
            if(first!=null)
                first = first.next;
            if(second!=null)
                second = second.next;
        }
        return first;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while(p1!=p2) {
            p1 = p1==null?headB:p1.next;
            p2 = p2==null?headA:p2.next;
        }
        return p1;
    }

    @Test
    public void test(){
        ListNode input1 = LinkedListUtils.buildLinkedList(new int[]{4,1,8,4,5});
        ListNode input2 = LinkedListUtils.buildLinkedList(new int[]{5,0,1,8,4,5});
        System.out.println(getIntersectionNode(input1,input2));
    }
}
