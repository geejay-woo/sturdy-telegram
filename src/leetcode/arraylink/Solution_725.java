package leetcode.arraylink;

import org.junit.Test;

public class Solution_725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode cur = root;
        while(cur!=null){
            cur = cur.next;
            len++;
        }
        int mod = len%k;
        int sz = len/k;
        ListNode[] res = new ListNode[k];
        for(cur = root; cur!=null && k!=0; k--) {
            res[res.length-k] = cur;
            int csz = sz+(mod-->0?1:0);
            for(int i = 0; i<csz-1; i++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }

    @Test
    public void test(){
        splitListToParts(LinkedListUtils.buildLinkedList(new int[]{1,2,3,4,5,6,7}),3);
    }
}
