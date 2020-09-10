package leetcode.arraylink;

import java.util.LinkedList;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 */
public class Solution_445 {
    /**
     * 如果两个数位数相同或者高位对齐相加可以使用递归，但是这里并不保证相同
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while(l1!=null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode(-1);
        int carry = 0;
        while(!stack1.isEmpty()||!stack2.isEmpty()||carry!=0) {
            int x = stack1.isEmpty()?0:stack1.pop();
            int y = stack2.isEmpty()?0:stack2.pop();
            int sum = (x+y+carry)%10;
            ListNode node = new ListNode(sum);
            node.next = head.next;
            head.next = node;
            carry = (x+y+carry)/10;
        }
        return head.next;
    }
}
