package ctci.chapter2;

import org.junit.Test;
import util.LinkedListUtils;

public class Solution2_4 {
    public Node partition(Node cur, int k){
        if(cur==null ) return null;
        Node head = partition(cur.next, k);
        if(head == null || cur.data<k){
            cur.next = head;
            return cur;
        } else {
            //将该节点加到head的尾部
            Node temp = head;
            while(temp.next!=null) temp = temp.next;
            temp.next = cur;
            //记得将新尾节点的next置为null
            cur.next = null;
            return head;
        }
    }

    @Test
    public void test(){
        Node node = partition(LinkedListUtils.buildLinkedList(new int[]{5, 3, 9, 2, 5, 7, 3}), 5);
        LinkedListUtils.showLinkedList(node);
    }
}
