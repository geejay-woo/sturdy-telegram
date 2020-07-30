package ctci.chapter2;

import org.junit.Test;
import util.LinkedListUtils;

import java.util.HashMap;
import java.util.HashSet;

public class Solution2_1 {
    //使用缓冲区
    public void deleteDups(Node n) {
        HashMap<Integer, Boolean> tbs = new HashMap();
        Node pre = null;
        while(n!=null) {
            if(tbs.containsKey(n.data)) {
                pre.next = n.next;
            } else {
                tbs.put(n.data,true);
                pre = n;
            }
            n = n.next;
        }
    }

    //不使用缓冲区
    //错误代码：自我审查
    public void deleteDups2(Node n) {
        //直接使用了pre.next但是没有检查null
        Node cur = n, pre = cur, node = pre.next;
        while(cur!=null) {

            //可以不用pre指针，只需要判断node.next即可
            pre = cur; node = pre.next;
            int curData = cur.data;
            while(node!=null) {
                if(node.data == curData)
                    pre.next = node.next;
                else
                    pre = node;
                node = node.next;
            }
            cur = cur.next;
        }
    }

    //最优代码
    public void deleteDups3(Node head) {
        if(head==null) return;

        Node current = head;
        while(current!=null) {
            //移除后续所有值相同的节点
            Node runner = current;
            while(runner.next!=null) {
                if(runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    @Test
    public void test(){
        Node node = LinkedListUtils.buildLinkedList(new int[]{5, 3, 9, 2, 5, 7, 3});
        deleteDups2(node);
        LinkedListUtils.showLinkedList(node);
    }
}
