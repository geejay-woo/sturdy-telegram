package jzoffer;

import entity.RandomListNode;

public class do35 {

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        n1.next = n2;
        n1.random = n3;
        n2.random = n3;
        n2.next = n3;
        RandomListNode clone = Clone(n1);
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        //复制
        RandomListNode cur = pHead;
        if(cur==null)
            return null;
        while(cur!=null) {
            //这里稍微调整下指针顺序，就能避免使用中间变量
            RandomListNode dup = new RandomListNode(cur.val);
            dup.next = cur.next;
            cur.next = dup;
            cur = dup.next;
        }
        //赋值
        cur = pHead;
        while(cur!=null) {
            if(cur.random!=null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //拆分
        RandomListNode ret = pHead.next;
        cur = pHead;
        while(cur.next!=null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return ret;
    }
}
