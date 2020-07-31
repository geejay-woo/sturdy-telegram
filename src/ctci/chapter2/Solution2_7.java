package ctci.chapter2;

import org.junit.Test;
import util.LinkedListUtils;

public class Solution2_7 {
    //编写函数判断链表是否为回文
    public boolean isPalindrome(Node head) {
        //翻转再比较
        if(head==null) return false;
        if(head.next==null) return true;

        //头插法
        Node list = null;
        Node temp = head;
        while(temp!=null) {
            Node node = new Node(temp.data);
            node.next = list;
            list = node;
            temp = temp.next;
        }

        boolean isPal = true;
        while(head!=null) {
            if(head.data!=list.data)
                isPal = false;
            head = head.next;
            list = list.next;
        }

        return isPal;

    }

    @Test
    public void test(){
        Node node = LinkedListUtils.buildLinkedList(new int[]{1, 2, 3, 2, 2});
        System.out.println(isPalindrome(node));

    }
}
