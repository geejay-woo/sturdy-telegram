package ctci.chapter2;

import org.junit.Test;
import util.LinkedListUtils;

public class Solution2_2 {
    //找出倒数第k个节点
    public int nthToLast(Node head, int k) {
        Node first = head, last = head;
        while(last!=null && --k!=0) {
            last = last.next;
        }
        //表示k大于链表长度
        if(last == null) return -1;
        while(last.next!=null) {
            first = first.next;
            last = last.next;
        }
        return first.data;
    }

    //递归，只能直接打印,返回的是计数器的值
    public int nthToLast2(Node cur, int k) {
        if(cur==null) return k;
        int i = nthToLast2(cur.next, k);
        if(i==1)
            System.out.println(cur.data);
        return i-1;
    }

    //递归答案解法
    public int nthToLast3(Node cur, int k) {
        if(cur==null) return 1;
        int i = nthToLast3(cur.next, k);
        if(i==k)
            System.out.println(cur.data);
        return i+1;
    }



    @Test
    public void test(){
        Node node = LinkedListUtils.buildLinkedList(new int[]{5, 3});
        System.out.println(nthToLast3(node,1));
    }
}
