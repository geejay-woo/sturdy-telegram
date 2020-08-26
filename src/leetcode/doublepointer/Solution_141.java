package leetcode.doublepointer;

import org.junit.Test;

public class Solution_141 {

    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode pre = head, cur = head;
        while(cur!=null && cur.next!=null) {
            pre = pre.next;
            cur = cur.next.next;
            if(pre==cur) return true;
        }
        return false;
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println(hasCycle(node1));
    }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}
